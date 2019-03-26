export default class Regra {
    constructor(axios, url) {
      this.axios = axios
      this.url = `${url}regra`
    }
    async findByIdPedido (id) {
      try {
        let response = await this.axios.get(`${this.url}/findbyidpedido`, { params: { idPedido: id } })
        return response.data
      } catch (err) {
        console.log({id})      
        console.log({err})
      }
    }
  }