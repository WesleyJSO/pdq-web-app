export default class Usuario {
  constructor (axios, url) {
    this.url = `${url}usuario`
    this.axios = axios
  }
  async findUsuarioByStsAtivo (ativo) {
    try {
      let response = await this.axios.get(`${this.url}/filtro`, {params: {stsAtivo: ativo}})
      return response.data
    }catch (err) {
      console.log({err})
    }
  }
}