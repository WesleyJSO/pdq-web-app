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
  /**
   * Generic get method, query for all data in the informed route.
   * @param { string } [path] Path to the endpoint  
   */
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
  /**
   * Generic put method to call any route with one entity as a parameter. 
   * @param { Object } [entity] Any known entity to persisty 
   * @param { String } [path] The path o any post method in the backend
   * 
   * @return { Object } Persisted entity in case of success or error nothing in case of error.
   */
  async putData(entity, path) {
    try {
      console.log(entity)
      this.store.commit('SHOW_LOADER')
      let response = await this.axios.put(`${this.url}${path}`, entity)
      this.store.commit('CLOSE_LOADER')
      return response.data
    } catch (err) {
      this.store.commit('CLOSE_LOADER')
      this.store.commit('SHOW_SNACKBAR', err.response.data.message)
    }
  }
}