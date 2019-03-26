export default class TipoTabela {
  constructor(store, axios, url) {
    this.store = store
    this.axios = axios
    this.url = `${url}tipotabela`
  }
  async findByIdPedido (id) {
    try {
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.get(`${this.url}/findbyidpedido`, { params: { id } })
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
}