<template>
  <v-card v-if="tabIndex === 0 && pedido" color="white" class="black--text">
    <v-card-text>
      <v-layout>
        
        <v-layout row>
          <v-flex md-6 >
            <p class="ma-2">Número do pedido: {{ pedido.codSap }}</p>
            <p class="ma-2">Status: {{ pedido.statusPedido.descricaoStatus }}</p>
            <!-- <p class="ma-2">Tabela: {{ tipoTabela.desTipoTabela }}</p> -->
            <p class="ma-2">Regional: {{ pedido.regional.nomRegional }}</p>
            <p class="ma-2">RTV: {{ pedido.usuarioRtv.login }}</p>
            <p class="ma-2">Cliente: {{ pedido.cliente.nomCliente }}</p>
            <p class="ma-2">Classificação cliente: {{ pedido.classificacaoCliente.desClassificacaoCliente }}</p>
            <p class="ma-2">Cidade cliente: {{ pedido.cliente.endereco.cidade.nomCidade }}</p>
            <p class="ma-2">Data de Criação: {{ pedido.dtCriacaoPedido | userFormatDate }}</p>
            <p class="ma-2">Tipo de Venda: {{ pedido.tipoVenda.desTipoVenda }}</p>
            <p class="ma-2">Pedido foi gerado há {{ pedido.dtCriacaoPedido | calculateDays }} dias</p>
          </v-flex>
        </v-layout>

        <v-layout column>
          <v-flex v-for="color in orderColors" :key="color.id" class="text-xs-right">
            <v-btn class="white--text" icon :color="color.orderColor">
              {{ color.colorPercentage }}%
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
      tabIndex: { type: Number, default: 0 },
      pedido: {  type: Object, default: () => {} }
    },
    async created () {
      this.pedido.listPedidoItem = [{produtoPrecoRegras: {tabelaPreco: {tipoTabela:{}}}}]
      this.tipoTabela = await this.$_TipoTabela.findByIdPedido(this.pedido.idPedido)
    },
    data: () => ({
      tipoTabela: {},
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

<style scoped>
.v-card__text {
  height: 441px;
}
</style>