export default class StatusPedido {
    constructor(axios, url) {
      this.axios = axios
      this.url = `${url}statuspedido`
    }
  }