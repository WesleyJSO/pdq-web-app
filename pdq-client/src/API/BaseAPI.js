export default class BaseAPI {
  constructor (axios, url) {
    this.url = `${url}`
    this.axios = axios
  }
  async authenticate() {
    try {
      let response = await this.axios.post(`${this.url}authenticate`)
      return response
    } catch (err) {
      console.log({err})
      return err
    }
  }
  async getData (path) {
    try {
      let response = await this.axios.get(`${this.url}${path}`)
      return response.data
    } catch (err) {
      console.log({path})
      console.log({err})
    }
  }
}