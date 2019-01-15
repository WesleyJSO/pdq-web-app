export default class BaseAPI {
  constructor (axios, url) {
    this.url = `${url}`
    this.axios = axios
  }
  async getData (path) {
    try {
      let response = await this.axios.get(`${this.url}${path}`)
      return response.data
    } catch (err) {
      console.log({err})
    }
  }
}