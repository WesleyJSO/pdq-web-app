<template>
  <div>
		<v-layout justify-space-between column fill-height>
			<v-flex>
				<v-toolbar tabs class="elevation-10">
					<v-text-field class="mx-3" flat solo-inverted label="Consultar PN" prepend-inner-icon="search" />
					<v-tabs	
						centered 
						v-model="mutableTabIndex" 
						slot="extension" 
						color="transparent"
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

				<v-tabs-items 
					v-model="tabs" 
					class="elevation-10"
				>
					<v-tab-item>
						<PedidoTabs :pedido="pedido" :tabIndex="mutableTabIndex" />
					</v-tab-item>
				</v-tabs-items>

			</v-flex>
      
			<v-flex>
				<Aprovacoes :idPedido="pedido.idPedido" />
			</v-flex>

		</v-layout>
  </div>
</template>

<script>
import PedidoTabs from './PedidoTabs'
import Aprovacoes from './Aprovacoes'
  export default {
    components: {
			PedidoTabs,
			Aprovacoes
		},
		props: {
      tabIndex: { type: Number, default: 1 },
      pedido: { type: Object, default: () => {} }
    },
		methods: {
			handleSelectedTab(v) {
				this.mutableTabIndex = v.id
			}
    },
    data() {
      return {
				mutableTabIndex: this.tabIndex,
        tabs: null,
				selectedOrder: null,
				tabItens: [
						{id: 0, name: 'Pedido'},
						{id: 1, name: 'Itens'},
						{id: 2, name: 'Outros'}
				]
      }
    }
  }
</script>
