export default class Funcionario {
  constructor (axios, url) {
    this.url = `${url}funcionario`
    this.axios = axios
  }
  async findByIdUsuario (id) {
    try {
      let response = await this.axios.get(`${this.url}/findbyidusuario`, { params: { id } } )
      return response.data
    }catch (err) {
      console.log({id})
      console.log({err})
    }
  }
}