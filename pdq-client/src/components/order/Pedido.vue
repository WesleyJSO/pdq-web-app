<template>
  <div>
		<v-layout justify-space-between column fill-height>
			<v-flex>
				<v-toolbar tabs>
					<v-text-field class="mx-3" flat solo-inverted label="Consultar PN" prepend-inner-icon="search" />
					<v-tabs	centered v-model="tabs" slot="extension" color="transparent">
						<v-tab v-for="element in tabItens" :key="element.id" @click="handleSelectedTab(element)">
							{{ element.name }}
						</v-tab>
					</v-tabs>
				</v-toolbar>

				<v-tabs-items v-model="tabs">
					<v-tab-item>
						<PedidoTabs :pedido="pedido" :tabIndex="tabIndex" />
					</v-tab-item>
				</v-tabs-items>

			</v-flex>
      
			<v-flex>
				<Aprovacoes />
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
				this.tabIndex = v.id
			}
    },
    data() {
      return {
        tabs: null,
				selectedOrder: null,
				tabItens: [
						{id: 1, name: 'Pedido'},
						{id: 2, name: 'Itens'},
						{id: 3, name: 'Outros'}
				]
      }
    }
  }
</script>
