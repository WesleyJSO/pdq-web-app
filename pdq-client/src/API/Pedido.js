export default class Pedido {
  constructor (axios, url) {
    this.axios = axios
    this.url = `${url}pedido`
  }
  async findPedidoByFilter (filterPedido) {
    try {
      // console.log(JSON.stringify(filterPedido, null, ' '))
      let response = await this.axios.post(`${this.url}/filtro`, filterPedido)
      return response.data
    } catch (err) {
      console.log({err})
    }
  }
}
