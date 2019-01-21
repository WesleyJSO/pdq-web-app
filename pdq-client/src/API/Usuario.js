export default class Usuario {
  constructor (axios, url) {
    this.url = `${url}usuario`
    this.axios = axios
  }
  async findByStsAtivo (ativo) {
    try {
      let response = await this.axios.get(`${this.url}/findbystsativo`, {params: {stsAtivo: ativo}})
      console.log({response})
      return response.data
    }catch (err) {
      console.log({ativo})
      console.log({err})
    }
  }
}