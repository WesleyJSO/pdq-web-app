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
            v-model="filterPedido.codSap"
          />
        </v-flex>
        <v-flex xs12 sm12 md4 lg4 xl4>
          <v-select 
            label="RTV"
            :items="listRtv"
            v-model="filterPedido.rtv"
            item-text="login"
            no-data-text="Não foi possível carregar a lista de representantes."
            return-object single-line
          />
        </v-flex>
        <v-flex xs12 sm12 md4 lg4 xl4>
          <v-select 
            label="Regional"
            :items="listRegional"
            v-model="filterPedido.regional"
            item-text="nomRegional"
            no-data-text="Não foi possível carregar a lista de regionais."
            return-object single-line
          />
        </v-flex>
      </v-layout>
      <v-layout>
        <v-flex xs12 sm12 md3 lg3 xl3>
          <v-select
            label="Estado"
            :items="listEstado"
            v-model="filterPedido.estado"
            :hint="`${filterPedido.estado.nomEstado} - ${filterPedido.estado.pais.nomPais}`"
            item-text="nomEstado"
            no-data-text="Não foi possível carregar a lista de estados."
            return-object single-line
            @change="findCidadeByIdEstado"
          />
        </v-flex>
        <v-flex xs12 sm12 md3 lg3 xl3>
          <v-select
            label="Cidade"
            :items="listCidade"
            v-model="filterPedido.cidade"
            item-text="nomCidade"
            no-data-text="Selecione um estado..."
            persistent-hint return-object single-line
          />
        </v-flex>
        <v-flex xs12 sm12 md6 lg6 xl6>
          <v-select 
            label="Status"
            :items="listStatusPedido"
            v-model="filterPedido.statusPedido"
            item-text="descricaoStatus"
            no-data-text="Não foi possível carregar a lista de status do pedido."
            return-object single-line     
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
    valid: false,
    filterPedido: {
      estado: { pais: {}},
      cidade: {},
      statusPedido: {}
    },
    listRtv: [],
    listRegional: [],
    listEstado: [],
    listCidade: [],
    listStatusPedido: []
  }),
  async mounted () {
    this.listRtv = await this.$_Usuario.findUsuarioByStsAtivo(true)
    this.listRegional = await this.$_BaseAPI.getData('regional')
    this.listEstado = await this.$_BaseAPI.getData('estado')
    this.listStatusPedido = await this.$_BaseAPI.getData('statuspedido')
  },
  methods: {
    async findCidadeByIdEstado () {
      this.listCidade = await this.$_Cidade.findCidadeByIdEstado(this.filterPedido.estado.idEstado) 
    },    
    validate () {
      if (this.refs.form.validate()) return
    },
    reset () {
      this.$refs.form.reset()
    }
  }
}
</script>
