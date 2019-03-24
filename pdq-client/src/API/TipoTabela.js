export default class TipoTabela {
    constructor(axios, url) {
      this.axios = axios
      this.url = `${url}tipotabela`
    }
    async findByIdPedido (id) {
      try {
        let response = await this.axios.get(`${this.url}/findbyidpedido`, { params: { id } })
        return response.data
      } catch (err) {
        console.log({id})      
        console.log({err})
      }
    }
  }