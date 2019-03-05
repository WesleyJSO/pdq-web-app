import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
	state: {
		status: '',
		token: localStorage.getItem('user-token') || '',
		user: localStorage.getItem('user') || "{}"
	},
	mutations: {
		auth_request(state) {
			state.status = 'loading'
		},
		auth_success(state, token, user) {
			state.status = 'success'
			state.token = token
			state.user = user
		},
		auth_error(state) {
			state.status = 'error'
		},
		logout(state) {
			state.status = ''
			state.token = ''
		},
	},
	actions: {
		login({ commit }, user) {
			return new Promise((resolve, reject) => {
				commit('auth_request')
				console.log({ user })
				axios({
						url: 'http://localhost:8888/api/login',
						data: user,
						method: 'POST'
					})
					.then(resp => {
						console.log({ resp })
						const token = resp.headers.authorization
						const user = resp.data
						const roles = user.authorities.map(role => role.authority)
						localStorage.setItem('user-token', token)
						let parsedUser = {
							user: user.username,
							roles,
							token
						}
						localStorage.setItem('user', JSON.stringify(parsedUser))
						// Add the following line:
						axios.defaults.headers.common['Authorization'] = token
						commit('auth_success', token, user, roles)
						resolve(resp)
					})
					.catch(err => {
						console.log({ err })
						commit('auth_error')
						localStorage.removeItem('user-token')
						localStorage.removeItem('user')
						reject(err)
					})
			})
		},
		logout({
			commit
		}) {
			return new Promise((resolve, reject) => {
				console.log(reject)
				commit('logout')
				localStorage.removeItem('user-token')
				localStorage.removeItem('user')
				delete axios.defaults.headers.common['Authorization']
				resolve()
			})
		}
	},
	getters: {
		isLoggedIn: state => !!state.token,
		authStatus: state => state.status,
		loggedUser: state => state.user ? JSON.parse(state.user) : {}
	}
})
