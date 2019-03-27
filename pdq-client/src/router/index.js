import Vue from 'vue'
import Router from 'vue-router'
import store from '../store'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      name: 'login',
      path: '/login',
      component: require('../components/login/Login').default,
    },
    {
      name: 'consultarpedido',
      path: '/consultarpedido',
      component: require('../components/searchorders/GridContainer').default,
      meta: {
        requiresAuth: true,
        roles: ['TUDO', 'ADM VENDAS']
      }
    },
    {
      name: 'aprovarpedido',
      path: '/aprovarpedido',
      component: require('../components/order/GridContainer').default,
      props: true,
      meta: {
        requiresAuth: true,
        roles: ['TUDO', 'ADM VENDAS']
      }
    },
    {
      name: 'fluxoaprovacao',
      path: '/fluxoaprovacao',
      component: require('../components/workflow/GridContainer').default,
      meta: {
        requiresAuth: true,
        roles: ['TUDO', 'ADM VENDAS']
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  try {
    if(to.name === 'login')
      next()
    else {
      let requiresAuth = to.matched.some(record => record.meta.requiresAuth)
      let requiresRole = requiresAuth && to.meta.roles ? to.matched.some(record => record.meta.roles.length) : false

      let change = false
      if (!requiresAuth) 
        change = true
      else if (store.getters.isLoggedIn)
        change = true
      else
        change = false

      if (!change)
        change = false
      else if (!requiresRole)
        change = true
      else if (!store.getters.loggedUser) {
        change = false
      } else {
        let user = store.getters.loggedUser
        for (let role of user.authorities) {
          change = to.meta.roles.includes(role.authority)
          if(change === true)
            break
        }
      }
      change ? next() : window.location.href = process.env.VUE_APP_S3_URL_LOGIN
    }
  } catch (err) {
    console.log({err})
    window.location.href = process.env.VUE_APP_S3_URL_LOGIN
  } 
})

export default router