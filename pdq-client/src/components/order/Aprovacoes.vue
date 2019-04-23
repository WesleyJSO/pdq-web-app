<template>
  <v-card light class="elevation-10">
    <v-card-title primary-title class="pa-0 pl-3 pt-2">
      <h3 class="headline">Aprovações</h3>
    </v-card-title>
    <v-card-text class="pa-0 pl-3">
      <v-container fluid>
        <v-layout row wrap>
          <v-flex v-for="(element, index) in listControleAprovacao" :key="element.id">
            <v-checkbox class="pa-0 pl-3"
              :disabled="!mapPermissionsControleAprovacao[index]"
              :color="checkBoxColor"
              :label="element.statusPedido.descricaoStatus"
              v-model="element.approved" />
          </v-flex>
        </v-layout>
      </v-container>
    </v-card-text>
    <v-card-actions>
      <v-btn color="#145661" class="white--text" @click="approve" depressed small>Aprovar</v-btn>
      <v-btn color="#808000" class="white--text" @click="disapprove" depressed small>Reprovar</v-btn>
      <v-btn color="#971900" class="white--text" @click="cancel" depressed small>Cancelar</v-btn>
      <v-btn color="light-blue darken-3" class="white--text" :disabled=true depressed small>Desfazer Alterações</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
  import store from '../../store'
  export default {
    props: {
      pedido: { type: Object, default: () => {} }
    },
    async created () {
      this.listControleAprovacao = await this.$_ControleAprovacao.findByIdPedido(this.pedido.id)
      this.verifyUserApprovalPermissions()
    },
    data () {
      return {
        checkBoxColor: 'indigo',
        listControleAprovacao: [],
        mapPermissionsControleAprovacao:[]
      }
    },
    methods: {
      async approve(){
        this.changeStatus()
      },
      async disapprove(){
        this.listControleAprovacao.forEach(approval => {
          approval.disapproved = true
        })
        this.changeStatus()
      },
      async cancel(){
        this.listControleAprovacao.forEach(approval => {
          approval.canceled = true
        })
        this.changeStatus()
      },
      async changeStatus(){
        let pedido
        pedido = await this.$_BaseAPI.putData({id: this.pedido.id, listControleAprovacao: this.listControleAprovacao}, 'pedido/changestatus')
        this.listControleAprovacao = await this.$_ControleAprovacao.findByIdPedido(this.pedido.id)
        this.$emit('changed', pedido)
        this.verifyUserApprovalPermissions()
      },
      verifyUserApprovalPermissions() {
        this.mapPermissionsControleAprovacao = []
        this.listControleAprovacao.forEach(approval => {
          let hasPermission = false
          // verify user permissions
          store.getters.userRoles.forEach(role => {
            if (approval.regra.perfil && approval.regra.perfil.id === role.id) {
              hasPermission = true
            // if term rule
            }
          })
          if (approval.regra.aprovador){
            if (approval.regra.aprovador === store.getters.loggedUser.id){
              hasPermission = true
            }
          }
          let enable = hasPermission
          // verify approval status
          if (approval.approved === true || approval.disapproved === true || approval.canceled === true) {
            enable = false
          }
          this.mapPermissionsControleAprovacao.push(enable)
        })
      }
    }
  }
</script>