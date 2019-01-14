<template>
  <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-container fluid>
      <v-layout>
        <v-flex xs12 sm12 md4 lg4 xl4> 
          <v-text-field 
            label="Numero do Pedido"
            v-model="pedido.codSap"
          />
        </v-flex>
        <v-flex xs12 sm12 md4 lg4 xl4>
          <v-text-field 
            label="RTV"
            v-model="pedido.rtv"
          />
        </v-flex>
        <v-flex xs12 sm12 md4 lg4 xl4>
          <v-text-field 
            label="Regional"
            v-model="pedido.regional"
          />
        </v-flex>
      </v-layout>
      <v-layout>
        <v-flex xs12 sm12 md4 lg4 xl4>
          <v-text-field 
            label="Estado"
            v-model="pedido.estado"
          />
        </v-flex>
        <v-flex xs12 sm12 md4 lg4 xl4>
          <v-text-field 
            label="Cidade"
            v-model="pedido.cidade"
          />
        </v-flex>
        <v-flex xs12 sm12 md4 lg4 xl4>
          <v-text-field 
            label="Status"
            v-model="pedido.status"
          />
        </v-flex>
      </v-layout>
    </v-container>
    <v-btn color="success" @click="validate">Pesquisar</v-btn>
    <v-btn color="warning" @click="reset">Limpar</v-btn>
  </v-form>
</template>

<script>
export default {
  data: () => ({
    pedido: {}
  }),
  mounted () {
    this.getEstados()
    // this.getCidade()
  },
  methods: {
    getEstados () {
      let estados = this.$_Estado.getEstados()
      console.table(estados)
    },
    // getCidades () {
    // },
    validate () {
      if (this.refs.form.validate()) return
    },
    reset () {
      this.$refs.form.reset()
    }
  }
}
</script>
