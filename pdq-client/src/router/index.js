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
        roles: [{id: 11, authority: 'TUDO'}, {id: 5, authority: 'ADM VENDAS'}]
      }
    },
    {
      name: 'aprovarpedido',
      path: '/aprovarpedido',
      component: require('../components/order/GridContainer').default,
      props: true,
      meta: {
        requiresAuth: true,
        roles: [{id: 11, authority: 'TUDO'}, {id: 5, authority: 'ADM VENDAS'}]
      }
    },
    {
      name: 'fluxoaprovacao',
      path: '/fluxoaprovacao',
      component: require('../components/workflow/GridContainer').default,
      meta: {
        requiresAuth: true,
        roles: [{id: 11, authority: 'TUDO'}, {id: 5, authority: 'ADM VENDAS'}]
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
        for (let role of user.roles) {
          for (let metaRole of to.meta.roles) {
            if (metaRole.authority === role.authority && metaRole.id === role.id) {
              change = true
              break
            }
          }
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