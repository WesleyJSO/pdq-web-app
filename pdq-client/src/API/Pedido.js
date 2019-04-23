export default class Pedido {
  constructor(store, axios, url) {
    this.store = store
    this.axios = axios
    this.url = `${url}pedido`
  }
  async findByFilter(filterPedido, message) {
    try {
      this.store.commit('SHOW_LOADER', message)
      let response = await this.axios.post(`${this.url}/findbyfilter`, filterPedido)
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
  async findByCodSap(codSap) {
    try {
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.get(`${this.url}/findbycodsap`, { params: { codSap } })
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
  async changeStatus(pedido) {
    try {
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.put(`${this.url}/changestatus`, pedido)
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
}