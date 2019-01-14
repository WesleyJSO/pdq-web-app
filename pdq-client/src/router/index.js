import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    { path: '/consultarpedido', component: require('../components/searchorders/GridContainer').default },
    { path: '/aprovarpedido', component: require('../components/order/GridContainer').default },
    { path: '/fluxoaprovacao', component: require('../components/workflow/GridContainer').default }
  ]
})