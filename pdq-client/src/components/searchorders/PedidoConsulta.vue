<template>
  <v-container fluid class="pa-0">
    <v-dialog v-model="snackbar" persistent/>
    <v-snackbar v-model="snackbar" top right :timeout="timeout">
      <v-progress-circular v-if="progress" indeterminate :value="20"></v-progress-circular>
      {{ snackbarText }}
      <v-btn color="pink" flat @click="isLoading = false">Fechar</v-btn>
    </v-snackbar>

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
            <v-btn color="success" :loading="isLoading" @click="search">Pesquisar</v-btn>
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
                :disabled="!$v_StatusPedido.validApprovalStatus(props.item.statusPedido.id)"
                :to="{ name: 'aprovarpedido', params: { pedido: props.item, tabIndex: 0 } }"
              >
                <v-list-tile-action>
                  <v-icon>done</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                  <v-list-tile-title>Aprovar</v-list-tile-title>
                </v-list-tile-content>
              </v-list-tile>
              <!-- <v-list-tile
                :enabled="enableSendApprovement(props.item.statusPedido)"
                v-else
                :color="actionColor(props.item.statusPedido)"
                slot="activator"
                key="enviarpedidoaprovacao"
                @click="sendToApprovement(props.item)"
              >
                <v-list-tile-action>
                  <v-icon>done</v-icon>
                </v-list-tile-action>
                <v-list-tile-content style="color: #1976d2">
                  <v-list-tile-title>Enviar para Aprovação</v-list-tile-title>
                  <v-list-tile-title>Aprovar</v-list-tile-title>
                </v-list-tile-content>
              </v-list-tile> -->
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
    headers: [
      { text: "Nome do cliente", value: "nomCliente", align: "left" },
      { text: "Regional", value: "nomRegional", align: "left" },
      { text: "Inscrição estadual", value: "numIe", align: "left" },
      { text: "Número do pedido", value: "codSap", align: "left" },
      { text: "Status", value: "descricaoStatus", align: "left" },
      { text: "Data de criação", value: "dtCriacaoPedido", align: "left" },
      { text: "Ações", value: "acoes", align: "center", sortable: false }
    ],
    timeout: 2000,
    isLoading: false,
    valid: false,
    progress: false,
    snackbar: false,
    snackbarText: "Pesquisando...",
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
    
    this.snackbarActiveInitiate(false)

    await this.login()
    
    this.listEstado = await this.$_BaseAPI.getData("estado")
    this.listEstado.sort((e1, e2) => (e1.nomEstado > e2.nomEstado) ? 1 : -1)

    this.listStatusPedido = await this.$_BaseAPI.getData("statuspedido")
    this.listStatusPedido.sort((e1, e2) => (e1.descricaoStatus > e2.descricaoStatus) ? 1 : -1)

    this.listCidade = await this.$_BaseAPI.getData("cidade")
    this.listCidade.sort((e1, e2) => (e1.nomCidade > e2.nomCidade) ? 1 : -1)
    
    this.listRegional = await this.$_Regional.findByUsuarioLogado()
    this.listRtv = await this.$_Usuario.findByStsAtivo(true)

    this.snackBarFinish()
  },
  methods: {
    /**
     * @FIXME @MOCK user login
     */
    async login() {
      console.log("user data persisted in store")
      let login = "ADMIN"
      let password = "!Quad123"
      await this.$store.dispatch("login", { login, password })
    },
    selectColor(valid) {
      if(valid) {
        return '#1976d2'
      }
    },
    enableAproval(status) {return !this.enableSendApprovement(status)},
    enableSendApprovement(status){
      let descricao = status.descricaoStatus.toUpperCase()
      if(descricao === 'EM CONSTRUCAO'){
        return true
      } else {
        return false
      }
    },
    actionColor(status) {console.log(status)},
    async findRegionalByIdUsuario() {
      console.log(this.filterPedido)
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
      this.snackbarActiveInitiate(true)
      this.listPedido = await this.$_Pedido.findByFilter(this.filterPedido)
      this.snackBarFinish()
    },
    snackbarActiveInitiate(blockLoad) {
      this.snackbarText = "Pesquisando..."
      if(blockLoad)
        this.isLoading = true
      this.progress = this.snackbar = true
    },
    snackBarFinish() {
      this.snackbarText = "Consulta finalizada!"
      this.snackbar = true
      this.isLoading = this.progress = false
    },
    /* eslint-disable */
    async sendToApprovement(pedido) {
      this.snackbarText = "Enviando...";
      this.isLoading = this.progress = this.snackbar = true;
      pedido = await this.$_Pedido.sendToApprovement(pedido);
      this.snackbarText = "Pedido enviado para aprovação!";
      this.snackbar = true;
      this.isLoading = this.progress = false;
    },
    reset() {
      this.$refs.form.reset(),
        (this.isLoading = false),
        (this.filterPedido = {
          estado: { pais: {} },
          cidade: { estado: {} }
        })
    }
  }
}
</script>
