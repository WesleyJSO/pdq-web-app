import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import axios from 'axios'
import moment from 'moment'

moment.updateLocale('en', {
  months: [
    'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
    'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
  ]
})

Vue.config.productionTip = false

Vue.prototype.$_axios = axios
Vue.prototype.$_moment = moment

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

new Vue({
  render: h => h(App),
}).$mount('#app')
