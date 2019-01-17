<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>

      <!-- Detalhes do pedido -->
      <v-flex d-flex xs12 sm12 md12 lg12 xl12>
        <v-card>
          <v-card-title class="title">Detalhes do Pedido</v-card-title>
          <v-card-text><OrderDetails /></v-card-text>
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
            <v-card-text><OrderTimeline /></v-card-text>
          </v-card>
        </v-hover>
      </v-flex> -->

    </v-layout>
  </v-container>
</template>

<script>
// import OrderTimeline from './OrderTimeline'
import OrderDetails from './OrderDetails'
  export default {
    components: {
      // OrderTimeline,
      OrderDetails
    },
    data: () => ({
      lorem: `Lorem ipsum dolor sit amet, mel at clita quando. Te sit oratio vituperatoribus, nam ad ipsum posidonium mediocritatem, explicari dissentiunt cu mea. Repudiare disputationi vim in, mollis iriure nec cu, alienum argumentum ius ad. Pri eu justo aeque torquatos.`
    })
  }
</script>