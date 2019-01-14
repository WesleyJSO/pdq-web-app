<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>

      <v-flex d-flex xs12 sm12 md12 lg12 xl12>
        <v-card color="#eee">
          <v-card-title class="title">Consulta de pedidos</v-card-title>
          
          <v-card-text>
            <!-- Dados da consulta -->
            <v-flex><OrdersSearch /></v-flex>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import OrdersSearch from './OrdersSearch'
  export default {
    components: {
      OrdersSearch
    },
    data: () => ({})
  }
</script>
