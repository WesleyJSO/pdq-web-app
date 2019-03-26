export default class Usuario {
  constructor(store, axios, url) {
    this.store = store
    this.url = `${url}usuario`
    this.axios = axios
  }
  async findByStsAtivo (ativo) {
    try {
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.get(`${this.url}/findbystsativo`, {params: {stsAtivo: ativo}})
      this.store.commit('CLOSE_LOADER')
      return response.data
    }catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
}