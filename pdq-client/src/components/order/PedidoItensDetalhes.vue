<template>
	<v-card light v-if="tabIndex === 1 && listItemPedido">
		<v-card-text>
				<v-data-table
					:headers="headers"
					:items="listItemPedido"
					rows-per-page-text="Itens por página"
				>
				<template slot="items" slot-scope="props">
					
						<td class="pa-3">
							<v-btn icon class="white--text" :color="itemColor(props.item.corPedido.id)" />
						</td>
						<td>{{ props.item.motivoErroSap }}</td>
						<td>{{ props.item.produtoPrecoRegras.tabelaPreco.dtIni }}</td>
						<td>{{ props.item.pedido.regional.centroLucro.descricao }}</td>
						<td>{{ props.item.pedido.usuarioRtv.funcionario.nomFuncionario }}</td>
						<td>{{ props.item.pedido.estadoOrigem.sigla }}</td>
						<td>{{ props.item.produtoPrecoRegras.produto.id }}</td>
						<td>{{ props.item.produtoPrecoRegras.produto.desProduto }}</td>
						<td>{{ props.item.quantidade }}</td>
						<td>{{ props.item.unidade.siglaUnidade }}</td>
						<td>{{ props.item.pedido.tipoVenda.desTipoVenda }}</td>
						<td>{{ props.item.organizacaoVendas.desOrganizacaoVendas }}</td>
						<td>{{ props.item.fabrica.desFabrica }}</td>
						<td>{{ props.item.dataFaturamento }}</td>
						<td>{{ props.item.pedido.setorAtividade.desSetorAtividade }}</td>
						<td>{{ props.item.pedido.cliente.canalDistribuicao.desCanalDistribuicao }}</td>
						<td>{{ props.item.condicaoPagamento.condPagamento }}</td>
						<td>{{ props.item.dataPagamento }}</td>
						<td>{{ props.item.pedido.codSap }}</td>
						<td>{{ props.item.pedido.cliente.codSap }}</td>
						<td>{{ props.item.pedido.cliente.nomCliente }}</td>
						<td>{{ props.item.pedido.cliente.numIe }}</td>
						<td>{{ props.item.pedido.cliente.endereco.cidade.estado.sigla }}</td>
						<td>{{ props.item.agenteFixoPorcent }}</td>
						<td>{{ props.item.agenteFixoValorPorKilo }}</td>
						<td>{{ props.item.agenteRateioPorcentSap }}</td>
						<td>
							mostrar todas as linhas de produto em combo box de visualização
							props.item.listCampanha.nomCampanha
						</td>
						<td>{{ props.item.cultura.desCultura }}</td>
						<td>{{ props.item.dataFaturamento }}</td>
					
					</template>
				</v-data-table>
		</v-card-text>
	</v-card>
</template>

<script>
	export default {
    methods: {
      itemColor (id) {
        if (id === 1) return 'blue'// azul
        else if (id === 2) return 'yellow' // amarelo
        else if (id === 3) return 'green' // verde
        else if (id === 4) return 'red' // vermelho
        else if (id === 5) return 'black' // preto
      }
		},
		props: {
			listItemPedido: { type: Array, default: () => [] },
      tabIndex: { type: Number, default: 1 }
		},
		data () {
			return {
				headers: [
					{ text: 'Cor', value: 'id', align: 'left' },
					{ text: 'Motivo Erro', value: 'motivoErroSap', align: 'left' },
					{ text: 'Data Vigência Tabela', value: 'dtIni', align: 'left' },
					{ text: 'Centro Lucro', value: 'descricao', align: 'left' },
					{ text: 'RTV', value: 'nomFuncionario', align: 'left' },
					{ text: 'UF Origem', value: 'sigla', align: 'left' },
					{ text: 'Código SAP', value: 'idProduto', align: 'left' },
					{ text: 'Descrição', value: 'desProduto', align: 'left' },
					{ text: 'Quantidade', value: 'quantidade', align: 'left' },
					{ text: 'Unidade', value: 'siglaUnidade', align: 'left' },
					{ text: 'Tipo Venda', value: 'desTipoVenda', align: 'left' },
					{ text: 'Organização Venda', value: 'desOrganizacaoVendas', align: 'left' },
					{ text: 'Fabrica', value: 'desFabrica', align: 'left' },
					{ text: 'Data Prevista', value: 'dataFaturamento', align: 'left' },
					{ text: 'Setor', value: 'desSetorAtividade', align: 'left' },
					{ text: 'Canal', value: 'desCanalDistribuicao', align: 'left' },
					{ text: 'Condição Pagamento', value: 'condPagamento', align: 'left' },
					{ text: 'Data Fixa', value: 'dataPagamento', align: 'left' },
					{ text: 'Número Pedido', value: 'codSap', align: 'left' },
					{ text: 'Código SAP Cliente', value: 'codSap', align: 'left' },
					{ text: 'Nome Cliente', value: 'nomCliente', align: 'left' },
					{ text: 'IE', value: 'numIe', align: 'left' },
					{ text: 'UF Cliente', value: 'sigla', align: 'left' },
					{ text: '% Comissão Agente', value: 'agenteFixoPorcent', align: 'left' },
					{ text: 'R$ KG Comissão Agente', value: 'agenteFixoValorPorKilo', align: 'left' },
					{ text: '% Comissã Agente Rateio', value: 'agenteRateioPorcentSap', align: 'left' },
					{ text: 'Campanhas', value: 'nomCampanha', align: 'left' },
					{ text: 'Cultura', value: 'desCultura', align: 'left' },
					{ text: 'Data Prevista Faturamento', value: 'dataFaturamento', align: 'left' }
				]
			}
		}
	}
</script>

<style scoped>
.v-card__text {
  height: 441px;
}
</style>