export default class Cidade {
  constructor(store, axios, url) {
    this.store = store
    this.url = `${url}cidade`
    this.axios = axios
  }
  async findByIdEstado (id) {
    try {
      let cidade = {
        estado: {
          id: id
        }
      }
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.post(`${this.url}/filtro`, cidade)
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
}