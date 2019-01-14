export default class Estado {
  constructor (axios, url) {
    this.url = url
    this.axios = axios
  }
  static getEstatos () {
    return this.axios.get(this.url)
  }
}
