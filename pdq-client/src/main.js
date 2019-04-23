import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import axios from 'axios'
import moment from 'moment'
import router from './router'
import store from './store'
import BasicValidator from './rules/BasicValidator'
import StatusPedidoValidator from './rules/StatusPedidoValidator'
import BaseAPI from './API/BaseAPI'
import Cidade from './API/Cidade'
import Usuario from './API/Usuario'
import Pedido from './API/Pedido'
import PedidoItem from './API/PedidoItem'
import TipoTabela from './API/TipoTabela'
import Regra from './API/Regra'
import Regional from './API/Regional'
import StatusPedido from './API/StatusPedido'
import Funcionario from './API/Funcionario'
import ControleAprovacao from './API/ControleAprovacao'

moment.updateLocale('en', {
  months: [
    'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
    'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
  ]
})

Vue.config.productionTip = false

let url = process.env.VUE_APP_BASE_URL
Vue.prototype.$_url = url
Vue.prototype.$_axios = axios
Vue.prototype.$_moment = moment
Vue.prototype.$v_basic = new BasicValidator()
Vue.prototype.$v_StatusPedido = new StatusPedidoValidator()
Vue.prototype.$_BaseAPI = new BaseAPI(store, axios, url)
Vue.prototype.$_Cidade = new Cidade(store, axios, url)
Vue.prototype.$_Usuario = new Usuario(store, axios, url)
Vue.prototype.$_Pedido = new Pedido(store, axios, url)
Vue.prototype.$_PedidoItem = new PedidoItem(store, axios, url)
Vue.prototype.$_TipoTabela = new TipoTabela(store, axios, url)
Vue.prototype.$_Regra = new Regra(store, axios, url)
Vue.prototype.$_Regional = new Regional(store, axios, url)
Vue.prototype.$_StatusPedido = new StatusPedido(store, axios, url)
Vue.prototype.$_Funcionario = new Funcionario(store, axios, url)
Vue.prototype.$_ControleAprovacao = new ControleAprovacao(store, axios, url)

Vue.filter('userFormatDate', function (v) {
  if (!v || !moment(v).isValid) return 'date parse error'
  return moment(v).format('DD/MM/YYYY')
})

Vue.filter('javaFormatDate', function (v) {
  if (!v || !moment(v).isValid) return 'date parse error'
  return moment(v).format('YYYYMMDD')
})

Vue.filter('vueFormatDate', function (v) {
  if (!v || !moment(v).isValid) return 'date parse error'
  return moment(v).format('YYYY-MM-DD')
})

Vue.filter('calculateDays', function (v) {
  if (!v || !moment(v).isValid) return 'date parse error'
  return moment().diff(moment(v), 'days')
})

/* eslint-disable no-console */
new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')
