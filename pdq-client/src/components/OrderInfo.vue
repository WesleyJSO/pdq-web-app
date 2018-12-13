<template>
	<v-card v-if="tabIndex === 1 && order" color="white" class="black--text">
		<v-card-text>
			<v-layout>
				
				<v-layout row>
					<v-flex md-6 >
						<p class="ma-1">Pedido Número: {{ order.pn }}</p>
						<p class="ma-1">Status: {{ order.status }}</p>
						<p class="ma-1">Tabela: {{ order.tabelaPreco }}</p>
						<p class="ma-1">Regional: {{ order.regional }}</p>
						<p class="ma-1">RTV: {{ order.rtv }}</p>
						<p class="ma-1">Cliente Final: {{ order.clienteFinal }}</p>
						<p class="ma-1">Cliente: {{ order.cliente }}</p>
						<p class="ma-1">Data de Criação: {{ order.dataCriacao | userFormatDate }}</p>
						<p class="ma-1">Tipo de Venda: {{ order.tipoVenda }}</p>
						<p class="ma-1">Pedido foi gerado há {{ order.dataCriacao | calculateDays }} dias</p>
					</v-flex>
				</v-layout>

				<v-layout column>
					<v-flex md-6 offset-md6
						v-for="color in orderColors" :key="color.id" 
						class="text-xs-right"
					>
						<v-btn
							icon
							:color="color.orderColor">{{ color.colorPercentage }}%
						</v-btn>
					</v-flex>
				</v-layout>
			</v-layout>
		</v-card-text>
	</v-card>
</template>

<script>
  export default {
    props: {
      tabIndex: {
        type: Number,
        default: 1
      },
      order: { 
        type: Object,
        default: null 
      }
    },
    data: () => ({
      orderColors: [
        {
          id: 1,
          orderColor: 'light-blue darken-4',
          colorPercentage: 7
        },
        {
          id: 2,
          orderColor: 'green',
          colorPercentage: 32
        },
        {
          id: 3,
          orderColor: 'amber accent-3',
          colorPercentage: 11
        },
        {
          id: 4,
          orderColor: 'red',
          colorPercentage: 38
        },
        {
          id: 5,
          orderColor: 'black',
          colorPercentage: 12
        }
      ]
    })
  }
</script>