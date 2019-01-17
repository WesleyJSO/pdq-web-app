import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    { name: 'consultarpedido', path: '/consultarpedido', component: require('../components/searchorders/GridContainer').default },
    { name: 'aprovarpedido', path: '/aprovarpedido', component: require('../components/order/GridContainer').default, props: true },
    { name: 'fluxoaprovacao', path: '/fluxoaprovacao', component: require('../components/workflow/GridContainer').default }
  ]
})