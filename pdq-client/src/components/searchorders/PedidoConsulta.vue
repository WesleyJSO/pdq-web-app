<template>
  <v-container fluid class="pa-0">
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-container fluid class="pl-3 pr-3 pt-0">
        <v-card class="elevation-10">
          <v-card-text>
            <v-layout>
              <v-flex xs12 sm12 md4 lg4 xl4>
                <v-text-field label="Numero do Pedido" v-model="filterPedido.codSap"/>
              </v-flex>
              <v-flex xs12 sm12 md4 lg4 xl4>
                <v-autocomplete
                  label="RTV"
                  :items="listRtv"
                  v-model="filterPedido.usuarioRtv"
                  item-text="login"
                  no-data-text="Não foi possível carregar a lista de representantes."
                  return-object
                  single-line
                  @change="findRegionalByIdUsuario"
                />
              </v-flex>
              <v-flex xs12 sm12 md4 lg4 xl4>
                <v-autocomplete
                  label="Regional"
                  :items="listRegional"
                  v-model="filterPedido.regional"
                  item-text="nomRegional"
                  no-data-text="Não foi possível carregar a lista de regionais."
                  return-object
                  single-line
                />
              </v-flex>
            </v-layout>
            <v-layout>
              <v-flex xs12 sm12 md3 lg3 xl3>
                <v-autocomplete
                  label="Estado"
                  :items="listEstado"
                  v-model="filterPedido.estado"
                  :hint="`${filterPedido.estado.nomEstado} - ${filterPedido.estado.pais.nomPais}`"
                  item-text="nomEstado"
                  no-data-text="Não foi possível carregar a lista de estados."
                  return-object
                  single-line
                  @change="findCidadeByIdEstado"
                />
              </v-flex>
              <v-flex xs12 sm12 md3 lg3 xl3>
                <v-autocomplete
                  label="Cidade"
                  :items="listCidade"
                  v-model="filterPedido.cidade"
                  :hint="`${filterPedido.cidade.nomCidade} - ${filterPedido.cidade.estado.nomEstado}`"
                  item-text="nomCidade"
                  no-data-text="Não foi possível carregar a lista de cidades."
                  return-object
                  single-line
                />
              </v-flex>
              <v-flex xs12 sm12 md6 lg6 xl6>
                <v-autocomplete
                  label="Status"
                  :items="listStatusPedido"
                  v-model="filterPedido.statusPedido"
                  item-text="descricaoStatus"
                  no-data-text="Não foi possível carregar a lista de status do pedido."
                  return-object
                  single-line
                />
              </v-flex>
            </v-layout>
          </v-card-text>
          <v-card-actions>
            <v-btn color="success" @click="search">Pesquisar</v-btn>
            <v-btn color="warning" @click="reset">Limpar</v-btn>
          </v-card-actions>
        </v-card>
      </v-container>
    </v-form>

    <v-card class="elevation-10 ml-3 mr-3 mb-3">
      <v-card-text>
        <v-data-table :headers="headers" :items="listPedido" rows-per-page-text="Itens por página">
          <template slot="items" slot-scope="props">
            <td class="pa-3">{{ props.item.cliente.nomCliente }}</td>
            <td>{{ props.item.regional.nomRegional }}</td>
            <td>{{ props.item.cliente.numIe }}</td>
            <td>{{ props.item.codSap }}</td>
            <td>{{ props.item.statusPedido.descricaoStatus }}</td>
            <td>{{ props.item.dtCriacaoPedido | userFormatDate }}</td>
            <td class="pa-2 pt-0">
              <v-list-tile
                slot="activator"
                key="aprovarpedido"
                :color="selectColor(!$v_StatusPedido.validApprovalStatus(props.item.statusPedido.id))"
                :disabled="$v_StatusPedido.validApprovalStatus(props.item.statusPedido.id)"
                :to="{ name: 'aprovarpedido', params: { pedido: props.item, tabIndex: 0 } }"
              >
                <v-list-tile-action>
                  <v-icon>done</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                  <v-list-tile-title>Aprovar</v-list-tile-title>
                </v-list-tile-content>
              </v-list-tile>
            </td>
          </template>

          <template slot="no-data">
            <p class="text-md-center">Nenhum item para ser exibido.</p>
          </template>
        </v-data-table>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    valid: false,
    headers: [
      { text: "Nome do cliente", value: "nomCliente", align: "left" },
      { text: "Regional", value: "nomRegional", align: "left" },
      { text: "Inscrição estadual", value: "numIe", align: "left" },
      { text: "Número do pedido", value: "codSap", align: "left" },
      { text: "Status", value: "descricaoStatus", align: "left" },
      { text: "Data de criação", value: "dtCriacaoPedido", align: "left" },
      { text: "Ações", value: "acoes", align: "center", sortable: false }
    ],
    filterPedido: {
      estado: { pais: {} },
      cidade: { estado: {} }
    },
    listRtv: [],
    listRegional: [],
    listEstado: [],
    listCidade: [],
    listStatusPedido: [],
    listPedido: []
  }),
  async mounted() {
    this.listEstado = await this.$_BaseAPI.getData("estado")
    this.listEstado.sort((e1, e2) => (e1.nomEstado > e2.nomEstado) ? 1 : -1)

    this.listStatusPedido = await this.$_BaseAPI.getData("statuspedido")
    this.listStatusPedido.sort((e1, e2) => (e1.descricaoStatus > e2.descricaoStatus) ? 1 : -1)

    this.listCidade = await this.$_BaseAPI.getData("cidade")
    this.listCidade.sort((e1, e2) => (e1.nomCidade > e2.nomCidade) ? 1 : -1)
    
    this.listRegional = await this.$_Regional.findByUsuarioLogado()
    this.listRtv = await this.$_Usuario.findByStsAtivo(true)
  },
  methods: {
    selectColor(valid) {
      if(valid) {
        return '#1976d2'
      }
    },
    async findRegionalByIdUsuario() {
      this.listRegional = await this.$_Regional.findByIdUsuario(
        this.filterPedido.usuarioRtv.id
      )
    },
    async findCidadeByIdEstado() {
      this.listCidade = await this.$_Cidade.findByIdEstado(
        this.filterPedido.estado.id
      )
    },
    async search() {
      this.listPedido = await this.$_Pedido.findByFilter(this.filterPedido)
    },
    reset() {
      this.$refs.form.reset(),
        (this.filterPedido = {
          estado: { pais: {} },
          cidade: { estado: {} }
        })
    }
  }
}
</script>
