export default class StatusPedido {
  constructor(store, axios, url) {
    this.store = store
    this.axios = axios
    this.url = `${url}statuspedido`
  }
}