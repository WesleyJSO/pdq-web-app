<template>
  <div></div>
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
      let response = await this.authenticate('Validando o usuário.')
      if(response.status === 200 && response.data) {
        let loggedUser = response.data
        loggedUser.token = this.$route.query.token
        store.dispatch('setToken', loggedUser)
        response = await this.fetchOrder('Usuário encontrado, realizando a consulta do pedido selecionado.')
        if(response) {
          let pedido = response[0]
          this.$router.push({ name: 'aprovarpedido', params: { pedido, tabIndex: 1 } } )
        }
      } else {
        store.dispatch('logout')
        window.location.href = process.env.VUE_APP_S3_URL_LOGIN
      }
    },
    async authenticate () {
      this.$_axios.defaults.headers.common['Authorization'] = `Bearer  ${this.$route.query.token}`
      return await this.$_BaseAPI.authenticate()
    },
    async fetchOrder (message) {
      return await this.$_Pedido.findByFilter({ id: this.$route.query.id }, message )
    }
  }
}
</script>