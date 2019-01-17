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
						<OrderDetailsTabs :pedido="pedido" :tabIndex="selectedTabIndex" />
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
    beforeMount () {
      this.pedido = this.$route.params.pedido
      this.selectedTabIndex = this.$route.params.tabIndex
    },
		methods: {
			handleSelectedTab(v) {
				this.selectedTabIndex = v.id
			}
    },
    data() {
      return {
        pedido: {},
        tabs: null,
				selectedTabIndex: 1,
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
