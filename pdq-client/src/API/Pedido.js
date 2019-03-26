export default class Pedido {
  constructor(axios, url) {
    this.axios = axios
    this.url = `${url}pedido`
  }
  async findByFilter(filterPedido) {
    try {
      let response = await this.axios.post(`${this.url}/findbyfilter`, filterPedido)
      return response.data
    } catch (err) {
      console.log({ filterPedido })
      console.log({ err })
    }
  }
  async sendToApprovement(filterPedido) {
    try {
      let response = await this.axios.post(`${this.url}/computeapprovementlist`, filterPedido)
      return response.data
    } catch (err) {
      console.log({ filterPedido })
      console.log({ err })
    }
  }
}