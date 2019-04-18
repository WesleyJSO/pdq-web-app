package com.s3.business.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.Usuario;
import com.pdq.pedido.domain.UsuarioLinhaProduto;
import com.s3.dao.impl.PedidoItemDAO;
import com.s3.dao.impl.PerfilUsuarioDAO;
import com.s3.dao.impl.UsuarioDAO;
import com.s3.dao.impl.UsuarioLinhaProdutoDAO;
import com.s3.helper.PedidoHelper;
import com.s3.helper.PerfilHelper;
import com.s3.helper.StatusPedidoHelper;

/**
 * 
 * @author José Wesley Silva 
 * Muralis Assessoria e Tecnologia Ltda. 
 * 07-03-2019 10:35:17
 *
 */
@Component
public class FilterPedidoByStatusBonificacao implements IStrategy<PedidoHelper> {

	@Autowired private UsuarioDAO usuarioDAO;
	@Autowired private PerfilUsuarioDAO perfilUsuarioDAO;
	@Autowired private UsuarioLinhaProdutoDAO usuarioLinhaProdutoDAO;
	@Autowired private PedidoItemDAO pedidoItemDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {

		if (aEntity != null && aEntity.getStatusPedido() != null && aEntity.getStatusPedido().getId() != null) {

			// verify if any order exists in the collection
			Optional<Stream<Pedido>> optionalPedido = aCase.getResult().getEntities();
			if (!optionalPedido.isPresent() || Stream.of(optionalPedido).count() == 0)
				return;

			List<Long> listStatusPedido = Arrays.asList(StatusPedidoHelper.ID_STATUS_APROVACAO_SUPERA,
					StatusPedidoHelper.ID_STATUS_APROVACAO_SUPERA_GMT,
					StatusPedidoHelper.ID_STATUS_APROVACAO_BONIFICACAO_GP,
					StatusPedidoHelper.ID_STATUS_APROVACAO_BONIFICACAO_DIRETOR);

			// validate if the filter status is one of the informed above.
			if (listStatusPedido.contains(aEntity.getStatusPedido().getId())) {

				// find the user profile that have access to all orders status
				Usuario loggedUser = usuarioDAO.getLoggedUser();
				Boolean hasProfile = perfilUsuarioDAO.hasProfileByUsuarioAndPerfil(loggedUser, PerfilHelper.RTV)
						&& perfilUsuarioDAO.hasProfileByUsuarioAndPerfil(loggedUser, PerfilHelper.ADM_VENDAS);

				List<Pedido> filteredPedido = new ArrayList<>();

				// user wont have the profiles, remover every order with status
				if (!hasProfile) {
					List<UsuarioLinhaProduto> listLinhaProduto = usuarioLinhaProdutoDAO.findByUsuario(loggedUser)
							.collect(Collectors.toList());

					// search all the orders items and verify if they have the same approval status from the filter
					Filter<Pedido> f = new Filter<>();
					optionalPedido.get().forEach(p -> {
						f.setEntity(p);
						pedidoItemDAO.findByIdPedido(f).forEach(pi -> {
							if (pi.getStatusAprovacao().getId().equals(aEntity.getStatusPedido().getId()))
								if (!filteredPedido.contains(p)
										&& listLinhaProduto.contains(pi.getProdutoPrecoRegras().getLinhaProduto()))
									filteredPedido.add(p);
						});
					});
					aCase.getResult().clear();
					aCase.getResult().addEntities(filteredPedido.stream());
				}
			}
		}
	}
}
