<template>
  <v-layout row justify-center>
    <v-dialog
      v-model="dialog"
      max-width="350"
    >
      <v-card>
        <v-card-title>
          {{ message }}
        </v-card-title>
        <v-card-actions>
          <v-progress-linear 
            :indeterminate="true" 
          />
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
</template>

<script>
import store from '../../store'
export default {
  data () {
    return { 
      message: '',
      dialog: false
    }
  },
  async created () {
    this.dialog = true
    await this.login()
  },
  methods: {
    async login () {
      this.message = 'Validando o usuário.'
      let response = await this.authenticate()
      if(response.status === 200 && response.data) {
        let loggedUser = response.data
        loggedUser.token = this.$route.query.token
        store.dispatch('setToken', loggedUser)
        this.message = 'Usuário encontrado, realizando a consulta do pedido selecionado.'
        response = await this.fetchOrder()
        if(response) {
          let pedido = response[0]
          this.$router.push({ name: 'aprovarpedido', params: { pedido, tabIndex: 1 } } )
        }
      } else {
        this.dialog = false
        store.dispatch('logout')
        window.location.href = "http://localhost:8081/compassminerals/login.jsf"
      }
    },
    async authenticate () {
      this.$_axios.defaults.headers.common['Authorization'] = `Bearer  ${this.$route.query.token}`
      return await this.$_BaseAPI.authenticate()
    },
    async fetchOrder () {
      return await this.$_Pedido.findByFilter({ id: this.$route.query.id })
    }
  }
}
</script>