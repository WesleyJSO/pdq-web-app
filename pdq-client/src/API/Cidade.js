export default class Cidade {
  constructor(axios, url) {
    this.url = `${url}cidade`
    this.axios = axios
  }
  async findCidadeByIdEstado (id) {
    try {
      let cidade = {
        estado: {
          id: id
        }
      }
      let response = await this.axios.post(`${this.url}/filtro`, cidade)
      console.log({response})
      
      return response.data
    } catch (err) {
      console.log({id})
      console.log({err})
    }
  }
}