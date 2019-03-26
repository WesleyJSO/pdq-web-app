export default class BaseAPI {
  constructor(store, axios, url) {
    this.store = store
    this.url = `${url}`
    this.axios = axios
  }
  async authenticate(message) {
    try {
      this.store.commit('SHOW_LOADER', message)
      let response = await this.axios.post(`${this.url}authenticate`)
      this.store.commit('CLOSE_LOADER')
      return response
    } catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
      return err
    }
  }
  async getData (path) {
    try {
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.get(`${this.url}${path}`)
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
}