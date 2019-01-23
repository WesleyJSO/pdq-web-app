<template>
  <v-card light>
    <v-card-title primary-title class="pa-0 pl-3 pt-2">
      <h3 class="headline">Aprovações</h3>
    </v-card-title>
    <v-card-text class="pa-0 pl-3">
      <v-container fluid>
        <v-layout row wrap>
          <v-flex v-for="element in aprovations" :key="element.id">
            <v-checkbox class="pa-0 pl-3"
              :color="checkBoxColor"
              :label="element.description"
              :value="element.approved" />
          </v-flex>
        </v-layout>
      </v-container>
    </v-card-text>
    <v-card-actions>
      <v-btn color="green darken-3" class="white--text" small>Aprovado</v-btn>
      <v-btn color="yellow darken-4" class="white--text" small>Não Aprovado</v-btn>
      <v-btn color="red darken-3" class="white--text" small>Cancelado</v-btn>
      <v-btn color="light-blue darken-3" class="white--text" small>Desfazer Alterações</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
  export default {
    props: {
      idPedido: { type: String, default: '' }
    },
    async created () {
      this.listRegra = await $_Regra.findByIdPedido(this.idPedido)
    },
    data: () => ({
      checkBoxColor: 'indigo',
      listRegra: []
    })
  }
</script>