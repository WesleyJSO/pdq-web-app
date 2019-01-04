import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import axios from 'axios'
import moment from 'moment'
import router from './router'
import BasicValidator from './Rules/BasicValidator'

moment.updateLocale('en', {
  months: [
    'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
    'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
  ]
})

Vue.config.productionTip = false

Vue.prototype.$_axios = axios
Vue.prototype.$_moment = moment
Vue.prototype.$v_basic = new BasicValidator()

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


/* eslint-disable no-console */
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
