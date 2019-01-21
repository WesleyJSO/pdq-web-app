export default class Pedido {
  constructor (axios, url) {
    this.axios = axios
    this.url = `${url}pedido`
  }
  async findByFilter (filterPedido) {
    try {
      // console.log(JSON.stringify(filterPedido, null, ' '))
      let response = await this.axios.post(`${this.url}/findbyfilter`, filterPedido)
      console.log({response})
      return response.data
    } catch (err) {
      console.log({filterPedido})
      console.log({err})
    }
  }
}
