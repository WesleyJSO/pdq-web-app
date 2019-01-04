<template>
  <div>
		<v-layout justify-space-between column fill-height>
			<v-flex>
				<v-toolbar
					color="purple"
					dark
					tabs
				>
					<v-text-field
						class="mx-3"
						flat
						label="Consultar PN"
						prepend-inner-icon="search"
						solo-inverted
					></v-text-field>

					<v-tabs
						slot="extension"
						v-model="tabs"
						centered
						color="transparent"
						slider-color="amber accent-3"
					>
						<v-tab
							v-for="element in tabItens"
							:key="element.id"
							@click="handleSelectedTab(element)"
						>
							{{ element.name }}
						</v-tab>
					</v-tabs>
				</v-toolbar>

				<v-tabs-items v-model="tabs">
					<v-tab-item
						v-for="element in pedidos"
						:key="element.id"
					>
						<OrderDetailsTabs
							:order="pedidos[1]"
							:tabIndex="selectedTabIndex" 
						/>
					</v-tab-item>
				</v-tabs-items>
			</v-flex>

			<v-flex>
				<Approvals />
			</v-flex>

		</v-layout>
  </div>
</template>

<script>
import OrderDetailsTabs from './OrderDetailsTabs'
import Approvals from './Approvals'
  export default {
		components: {
			OrderDetailsTabs,
			Approvals
		},
		methods: {
			handleSelectedTab(v) {
				this.selectedTabIndex = v.id
			}
		},
    data() {
      return {
        tabs: null,
				selectedTabIndex: 0,
				selectedOrder: null,
				tabItens: [
						{id: 1, name: 'Pedido'},
						{id: 2, name: 'Itens'},
						{id: 3, name: 'Outros'}
				],
				pedidos: [
					{
						id: 1,
						pn: 'PN012018001',
						status: 'IMPLANTADO',
						tabelaPreco: 'T1 DIST',
						regional: 'CORPORATIVA AGRÍCOLA - 1053',
						rtv: 'MARJORY LOPES',
						clienteFinal: '(Produtor Rural) - BAMBUI',
						cliente: 'ADEMAR ANTONIO ROCHA',
						dataCriacao: '11/12/2018',
						tipoVenda: 'Bonificação',
						itensPedido: [
							{
								id: 1,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 2,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 3,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 4,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 5,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							}
						]
					},
					{
						id: 2,
						pn: 'PN012018001',
						status: 'IMPLANTADO',
						tabelaPreco: 'T1 DIST',
						regional: 'CORPORATIVA AGRÍCOLA - 1053',
						rtv: 'MARJORY LOPES',
						clienteFinal: '(Produtor Rural) - BAMBUI',
						cliente: 'ADEMAR ANTONIO ROCHA',
						dataCriacao: '20181201',
						tipoVenda: 'Bonificação',
						itensPedido: [
							{
								id: 1,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 2,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 3,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 4,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 5,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							}
						]
					},
					{
						id: 3,
						pn: 'PN012018001',
						status: 'IMPLANTADO',
						tabelaPreco: 'T1 DIST',
						regional: 'CORPORATIVA AGRÍCOLA - 1053',
						rtv: 'MARJORY LOPES',
						clienteFinal: '(Produtor Rural) - BAMBUI',
						cliente: 'ADEMAR ANTONIO ROCHA',
						dataCriacao: '11/12/2018',
						tipoVenda: 'Bonificação',
						itensPedido: [
							{
								id: 1,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 2,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 3,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 4,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							},
							{
								id: 5,
								cor: 'amarelo amarelo amarelo amarelo amareloamarelo amarelo',
								motivoErro: '',
								dataVigenciaTabela: '01/01/2019',
								centroLucro: 'Corporativo Agrícola',
								nomeRtv: 'Marjory Lopes',
								ufOrigem: 'SP',
								codProduto: '2000003195',
								descProduto: 'POLYBLEN MONTANHA 25-00-13 SAV 25KG',
								qantidade: 50.00,
								unidade: 'TO',
								tipoVenda: 'Bonificação',
								organizacaoVenda: 'Compass America Sul',
								fabrica: 'Compas America sul JACAREI II',
								dataPrevista: '12/01/2019',
								setor: 'Sem Aplicação',
								canal: 'Mercado Interno',
								condicaoPagamento: 'BONIFICAÇÃO COMERCIAL',
								datafixa: '',
								numeroPedido: 'PN0120180001',
								codSapCliente: '102016',
								nomeCliente: 'ADEMAR ANTONIO ROCHA',
								ie: 'ISENTO',
								ifCliente: 'MG',							
								porcentagemComissaoAgente: 0.00,
								reaisKGComissaoAgente: 0.00,
								porcentagemComissaoAgenteRateio: 0.00,
								campanhas: [
									{id: 1, nome: 'Campanha1'},
									{id: 2, nome: 'Campanha2'}
								],
								cultura: 'CANOLA',
								dataPrevistaFat: '12/01/2019'
							}
						]
					}
				]
      }
    }
  }
</script>
