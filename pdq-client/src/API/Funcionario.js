export default class Funcionario {
  constructor(store, axios, url) {
    this.store = store
    this.url = `${url}funcionario`
    this.axios = axios
  }
  async findByIdUsuario (id) {
    try {
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.get(`${this.url}/findbyidusuario`, { params: { id } } )
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
}