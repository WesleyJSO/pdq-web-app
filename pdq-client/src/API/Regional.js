export default class Regional {
  constructor(store, axios, url) {
    this.store = store
    this.axios = axios
    this.url = `${url}regional`
  }
  async findByUsuarioLogado () {
    try {
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.get(`${this.url}/findbyusuariologado`)
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {   
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }

  async findByIdUsuario (id) {
    try {
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.get(`${this.url}/findbyidusuario`, { params: { idUsuario: id } } )
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {   
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
}