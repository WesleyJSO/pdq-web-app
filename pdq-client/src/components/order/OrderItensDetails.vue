<template>
	<div>
		<v-card light v-if="tabIndex === 2  && orderItens" color="white" class="black--text">
			<v-card-text >
				<v-data-table
					:headers="headers"
					:items="orderItens"
					rows-per-page-text="Itens por página"
				>
				<template slot="items" slot-scope="props">
					
						<td class="pa-3">{{ props.item.cor }}</td>
						<td>{{ props.item.motivoErro }}</td>
						<td>{{ props.item.dataVigenciaTabela }}</td>
						<td>{{ props.item.centroLucro }}</td>
						<td>{{ props.item.nomeRtv }}</td>
						<td>{{ props.item.ufOrigem }}</td>
						<td>{{ props.item.codProduto }}</td>
						<td>{{ props.item.descProduto }}</td>
						<td>{{ props.item.quantidade }}</td>
						<td>{{ props.item.unidade }}</td>
						<td>{{ props.item.tipoVenda }}</td>
						<td>{{ props.item.organizacaoVenda }}</td>
						<td>{{ props.item.fabrica }}</td>
						<td>{{ props.item.dataPrevista }}</td>
						<td>{{ props.item.setor }}</td>
						<td>{{ props.item.canal }}</td>
						<td>{{ props.item.condicaoPagamento }}</td>
						<td>{{ props.item.dataFixa }}</td>
						<td>{{ props.item.numeroPedido }}</td>
						<td>{{ props.item.codSapCliente }}</td>
						<td>{{ props.item.nomeCliente }}</td>
						<td>{{ props.item.ie }}</td>
						<td>{{ props.item.ufCliente }}</td>
						<td>{{ props.item.porcentagemComissaoAgente }}</td>
						<td>{{ props.item.reaisKGComissaoAgente }}</td>
						<td>{{ props.item.porcentagemComissaoAgenteRateio }}</td>
						<td>{{ props.item.campanhas[0].nome }}</td>
						<td>{{ props.item.cultura }}</td>
						<td>{{ props.item.dataPrevistaFat }}</td>
					
					</template>
				</v-data-table>
			</v-card-text>
		</v-card>
	</div>
</template>

<script>
	export default {
		props: {
			orderItens: {
				type: Array
			},
      tabIndex: {
        type: Number,
        default: 1
      }
		},
		data: () => ({
			headers: [
        { text: 'Cor', value: 'cor', align: 'left' },
        { text: 'Motivo Erro', value: 'motivoErro', align: 'left' },
        { text: 'Data Vigência Tabela', value: 'dataVigenciaTabela', align: 'left' },
        { text: 'Centro Lucro', value: 'centroLucro', align: 'left' },
        { text: 'RTV', value: 'nomeRtv', align: 'left' },
        { text: 'UF Origem', value: 'ufOrigem', align: 'left' },
        { text: 'Código SAP', value: 'codProduto', align: 'left' },
        { text: 'Descrição', value: 'descProduto', align: 'left' },
        { text: 'Quantidade', value: 'quantidade', align: 'left' },
        { text: 'Unidade', value: 'unidade', align: 'left' },
        { text: 'Tipo Venda', value: 'tipoVenda', align: 'left' },
        { text: 'Organização Venda', value: 'organizacaoVenda', align: 'left' },
        { text: 'Fabrica', value: 'fabrica', align: 'left' },
        { text: 'Data Prevista', value: 'dataPrevista', align: 'left' },
        { text: 'Setor', value: 'setor', align: 'left' },
        { text: 'Canal', value: 'canal', align: 'left' },
        { text: 'Condição Pagamento', value: 'condicaoPagamento', align: 'left' },
        { text: 'Data Fixa', value: 'dataFixa', align: 'left' },
        { text: 'Número Pedido', value: 'numeroPedido', align: 'left' },
        { text: 'Código SAP Cliente', value: 'codSapCliente', align: 'left' },
        { text: 'Nome Cliente', value: 'nomeCliente', align: 'left' },
        { text: 'IE', value: 'ie', align: 'left' },
        { text: 'UF Cliente', value: 'ufCliente', align: 'left' },
        { text: '% Comissão Agente', value: 'porcentagemComissaoAgente', align: 'left' },
        { text: 'R$ KG Comissão Agente', value: 'reaisKGComissaoAgente', align: 'left' },
        { text: '% Comissã Agente Rateio', value: 'porcentagemComissaoAgenteRateio', align: 'left' },
        { text: 'Campanhas', value: 'campanhas', align: 'left' },
        { text: 'Cultura', value: 'cultura', align: 'left' },
        { text: 'Data Prevista Faturamento', value: 'dataPrevistaFat', align: 'left' }
      ]
		})
	}
</script>
