<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>

      <!-- Detalhes do pedido -->
      <v-flex d-flex xs12 sm12 md12 lg12 xl12>
        <v-card>
          <v-card-title class="title">Detalhes do Pedido</v-card-title>
          <v-card-text><Pedido :pedido="pedido" :tabIndex="tabIndex"/></v-card-text>
        </v-card>
      </v-flex>
      
      <!-- Timeline -->
      <!-- <v-flex d-flex xs12 sm12 md3 lg3 xl3>
        <v-hover>
          <v-card
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 12 : 2}`"
            class="mx-auto" dark
          >
            <v-card-title class="deep-orange title text--white">Histórico de Status</v-card-title>
            <v-card-text><PedidoTimeline /></v-card-text>
          </v-card>
        </v-hover>
      </v-flex> -->

    </v-layout>
  </v-container>
</template>

<script>
// import PedidoTimeline from './PedidoTimeline'
import Pedido from './Pedido'
  export default {
    components: {
      // PedidoTimeline,
      Pedido
    },
    async created () {
      this.tabIndex = this.$route.params.tabIndex
			this.pedido = this.$route.params.pedido
      this.pedido.listPedidoItem = await this.$_PedidoItem.findByIdPedido(this.pedido.idPedido)
    },
    data: () => ({
      tabIndex: 1,
      pedido: { }
    })
  }
</script>