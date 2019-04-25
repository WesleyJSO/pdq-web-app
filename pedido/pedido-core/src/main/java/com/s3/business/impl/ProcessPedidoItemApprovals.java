package com.s3.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.ControleAprovacaoPedidoItem;
import com.pdq.pedido.domain.LinhaProduto;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.RegraAprovacaoPrazo;
import com.pdq.pedido.domain.Usuario;
import com.s3.dao.impl.LinhaProdutoDAO;
import com.s3.dao.impl.UsuarioDAO;
import com.s3.helper.LinhaProdutoHelper;
import com.s3.helper.PedidoHelper;
import com.s3.helper.StatusPedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 24 de abr de 2019
 *
 */
@Component
public class ProcessPedidoItemApprovals implements IStrategy<PedidoHelper> {

	final static Logger LOG = LoggerFactory.getLogger(ProcessPedidoItemApprovals.class);

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private LinhaProdutoDAO linhaProdutoDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optional = aCase.getResult().getEntity();
		Pedido pedido = optional.get();

		Optional<Stream<ControleAprovacao>> approvedOptional = aCase.getResult()
				.getEntity("changeStatusControleAprovacaoResult");

		List<ControleAprovacao> listApproved = approvedOptional.get().collect(Collectors.toList());
		Optional<Stream<RegraAprovacaoPrazo>> regraAprovacaoPrazoOptional = aCase.getResult()
				.getEntity("findTermRulesResult");

		List<RegraAprovacaoPrazo> listRegra = regraAprovacaoPrazoOptional.get().collect(Collectors.toList());
		Usuario usuario = usuarioDAO.getLoggedUser();
		List<PedidoItem> itensToAprove = pedido.getListPedidoItem();
		for (ControleAprovacao controle : listApproved) {
			itensToAprove = getPedidoItensParaAprovacao(controle, usuario, pedido.getListPedidoItem(), listRegra);
			updateMap(itensToAprove, usuario, controle);
		}
		aCase.getResult().addEntity("changeStatusControleAprovacaoResult", listApproved.stream());
		aCase.getResult().addEntity("findTermRulesResult", listRegra.stream());
	}

	private void updateMap(List<PedidoItem> itensToAprove, Usuario usuario, ControleAprovacao controle) {
		ControleAprovacaoPedidoItem controleItem;
		for (PedidoItem item : itensToAprove) {
			controleItem = new ControleAprovacaoPedidoItem(item, controle.getStatusPedido(), usuario);
			item.getListControleAprovacaoPedidoItem().add(controleItem);
		}
	}

	public List<PedidoItem> getPedidoItensParaAprovacao(ControleAprovacao controle, Usuario usuario,
			List<PedidoItem> lstPedidoItem, List<RegraAprovacaoPrazo> listRegra) {
		Long idStatus = controle.getStatusPedido().getId();
		List<PedidoItem> itensToAprove = new ArrayList<>();

		if (controle.getRegra() instanceof RegraAprovacaoPrazo) {
			for (PedidoItem pi : lstPedidoItem) {
				for (RegraAprovacaoPrazo regraAprovacaoPrazo : listRegra) {
					if (usuario.getId().equals(regraAprovacaoPrazo.getAprovador().getId()) && regraAprovacaoPrazo
							.getLstLinhaProduto().contains(pi.getProdutoPrecoRegras().getLinhaProduto())) {
						itensToAprove.add(pi);
						LOG.info("Status " + controle.getStatusPedido().getDescricaoStatus() + " do item "
								+ pi.getProdutoPrecoRegras().getProduto().getDesProduto() + " aprovado por "
								+ usuario.getLogin() + " por meio da regra de prazo entre "
								+ regraAprovacaoPrazo.getDataVigenciaInicio() + " e "
								+ regraAprovacaoPrazo.getDataVigenciaFim() + " dias.");
						break;
					}
				}
				if (listRegra.isEmpty()) {
					itensToAprove.add(pi);
				}
			}
		} else if (idStatus.equals(StatusPedidoHelper.ID_STATUS_APROVACAO_DIRETOR_COMERCIAL)
				|| idStatus.equals(StatusPedidoHelper.ID_STATUS_APROVACAO_SUPERA)
				|| idStatus.equals(StatusPedidoHelper.ID_STATUS_APROVACAO_BONIFICACAO_GP)
				|| idStatus.equals(StatusPedidoHelper.ID_STATUS_APROVACAO_SUPERA_GMT)
				|| idStatus.equals(StatusPedidoHelper.ID_STATUS_APROVACAO_BONIFICACAO_DIRETOR)) {
			LinhaProdutoHelper lpHelper = new LinhaProdutoHelper();
			lpHelper.setIdUsuario(usuario.getId());
			Filter<LinhaProdutoHelper> filterLinhaProduto = new Filter<>();
			filterLinhaProduto.setEntity(lpHelper);
			List<LinhaProduto> lstLinhaUsuario = linhaProdutoDAO.findLinhaProdutoByIdUsuario(filterLinhaProduto)
					.collect(Collectors.toList());
			if (lstLinhaUsuario != null && !lstLinhaUsuario.isEmpty()) {
				for (PedidoItem pi : lstPedidoItem) {
					if (lstLinhaUsuario.contains(pi.getProdutoPrecoRegras().getLinhaProduto())) {
						itensToAprove.add(pi);
					}
				}
			}
		}  else {
			itensToAprove.addAll(lstPedidoItem);
		}
		return itensToAprove;
	}
}
