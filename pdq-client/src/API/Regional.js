export default class Regional {
    constructor(axios, url) {
      this.axios = axios
      this.url = `${url}regional`
    }
    async findByUsuarioLogado () {
      try {
        let response = await this.axios.get(`${this.url}/findbyusuariologado`)
        console.log({response})
        return response.data
      } catch (err) {   
        console.log({err})
      }
    }

    async findByIdUsuario (id) {
      try {
        let response = await this.axios.get(`${this.url}/findbyidusuario`, { params: { idUsuario: id } } )
        console.log({response})
        return response.data
      } catch (err) {   
        console.log({id})
        console.log({err})
      }
    }
  }