export default class BaseAPI {
  constructor (axios, url) {
    this.url = `${url}`
    this.axios = axios
  }
  async getData (path) {
    try {
      let response = await this.axios.get(`${this.url}${path}`)
      console.log({response})
      return response.data
    } catch (err) {
      console.log({path})
      console.log({err})
    }
  }
}