<template>
  <div>
		<v-layout justify-space-between column fill-height>
			<v-flex>
				<v-toolbar tabs class="elevation-10">
					<v-text-field 
						label="Consultar PN" 
						flat
						v-model="orderNumber"
						solo-inverted 
						class="mx-3" 
						prepend-inner-icon="search" 
						@keyup="fetchOrder" />
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
						<PedidoTabs :pedido="mutablePedido" :tabIndex="mutableTabIndex" />
					</v-tab-item>
				</v-tabs-items>

			</v-flex>
      
			<v-flex>
				<Aprovacoes :pedido="mutablePedido" @changed="changePedido" />
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
      tabIndex: { type: Number, default: 0 },
      pedido: { type: Object, default: () => {} }
    },
		methods: {
			handleSelectedTab(v) {
				this.mutableTabIndex = v.id
			},
			/**
			 *  13 is equals key: 'Enter', 
			 * and order number greater than 6 to prevent 
			 * call the api with a invalid number,
			 * orders usuario have at least more than six numbers
			 */
			async fetchOrder (event) {
				if (event.keyCode === 13 && this.orderNumber.length > 6)
					this.mutablePedido = await this.$_Pedido.findByCodSap(this.orderNumber)
			},
			changePedido(pedido){
				this.mutablePedido = pedido
			}
		},
    data () {
      return {
				orderNumber: '',
				mutablePedido: this.pedido,
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
