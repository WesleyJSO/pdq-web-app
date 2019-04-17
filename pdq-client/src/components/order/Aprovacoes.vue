<template>
  <v-card light class="elevation-10">
    <v-card-title primary-title class="pa-0 pl-3 pt-2">
      <h3 class="headline">Aprovações</h3>
    </v-card-title>
    <v-card-text class="pa-0 pl-3">
      <v-container fluid>
        <v-layout row wrap>
          <v-flex v-for="element in listRegra" :key="element.id">
            <v-checkbox class="pa-0 pl-3"
              :color="checkBoxColor"
              :label="element.description"
              :value="element.approved" />
          </v-flex>
        </v-layout>
      </v-container>
    </v-card-text>
    <v-card-actions>
      <v-btn color="#145661" class="white--text" depressed small @click="orderApproval">Aprovado</v-btn>
      <v-btn color="#808000" class="white--text" depressed small>Não Aprovado</v-btn>
      <v-btn color="#971900" class="white--text" depressed small>Cancelado</v-btn>
      <v-btn color="light-blue darken-3" class="white--text" depressed small>Desfazer Alterações</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
  export default {
    props: {
      pedido: { type: Object, default: () => {} }
    },
    async created () {
      this.listRegra = await this.$_Regra.findByIdPedido(this.pedido.id)
    },
    data () {
      return {
        checkBoxColor: 'indigo',
        listRegra: []
      }
    },
    methods: {
      async orderApproval () {
        if(this.pedido) {
          console.log(this.pedido)
          let i = await this.$_BaseAPI.putData(this.pedido, 'pedido/changestatus')
          console.log(i)
        }
      }
    }
  }
</script>