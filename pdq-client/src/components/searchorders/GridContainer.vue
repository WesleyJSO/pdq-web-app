<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>

      <v-flex d-flex xs12 sm12 md12 lg12 xl12>
        <v-card flat class="card">
          <v-card-title class="title card">Consulta de pedidos</v-card-title>
          
          <v-card-text class="pa-0">
            <!-- Dados da consulta -->
            <v-flex><PedidoConsulta /></v-flex>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import PedidoConsulta from './PedidoConsulta'
  export default {
    components: {
      PedidoConsulta
    },
    data: () => ({})
  }
</script>

<style scoped>
  .card {
    background-color: #ECF0F1;
  }
</style>
