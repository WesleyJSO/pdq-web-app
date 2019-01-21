import Vue from 'vue'
import Vuex from 'vuex'
import './plugins/vuetify'
import App from './App.vue'
import axios from 'axios'
import moment from 'moment'
import router from './router'
import BasicValidator from './rules/BasicValidator'
import BaseAPI from './API/BaseAPI'
import Cidade from './API/Cidade'
import Usuario from './API/Usuario'
import Pedido from './API/Pedido'
import PedidoItem from './API/PedidoItem'
import TipoTabela from './API/TipoTabela'

moment.updateLocale('en', {
  months: [
    'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
    'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
  ]
})

Vue.config.productionTip = false

let url = 'http://localhost:8888/api/'
Vue.prototype.$_url = url
Vue.prototype.$_axios = axios
Vue.prototype.$_moment = moment
Vue.prototype.$v_basic = new BasicValidator()
Vue.prototype.$_BaseAPI = new BaseAPI(axios, url)
Vue.prototype.$_Cidade = new Cidade(axios, url)
Vue.prototype.$_Usuario = new Usuario(axios, url)
Vue.prototype.$_Pedido = new Pedido(axios, url)
Vue.prototype.$_PedidoItem = new PedidoItem(axios, url)
Vue.prototype.$_TipoTabela = new TipoTabela(axios, url)

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

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    count: 10
  },
  mutations: {
    increment (state) {
      state.count++
    }
  }
})

/* eslint-disable no-console */
new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')
