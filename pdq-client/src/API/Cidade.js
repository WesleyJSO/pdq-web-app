export default class Cidade {
  constructor(axios, url) {
    this.url = `${url}cidade`
    this.axios = axios
  }
  async findCidadeByIdEstado (idEstado) {
    try {
      let cidade = {
        estado: {
          idEstado: idEstado
        }
      }
      let response = await this.axios.post(`${this.url}/filtro`, cidade)
      return response.data
    } catch (err) {
      console.log({err})
    }
  }
}