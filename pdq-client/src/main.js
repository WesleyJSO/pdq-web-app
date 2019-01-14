import Vue from 'vue'
import Vuex from 'vuex'
import './plugins/vuetify'
import App from './App.vue'
import axios from 'axios'
import moment from 'moment'
import router from './router'
import BasicValidator from './rules/BasicValidator'
import Estado from './API/Estado'

moment.updateLocale('en', {
  months: [
    'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
    'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
  ]
})

Vue.config.productionTip = false

Vue.prototype.$_axios = axios
Vue.prototype.$_url = 'http://localhost:8888/'
Vue.prototype.$_moment = moment
Vue.prototype.$v_basic = new BasicValidator()
Vue.prototype.$_Estado = new Estado(this.$_axios, `${this.$_url}/estado`)

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
  let today = moment(moment().format('YYYYMMDD')).format('DDD')
  return today - moment(v).format('DDD')
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
