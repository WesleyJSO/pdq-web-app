import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
	/**
	 * initial application data
	 */
	state: {
		show: false,
		message: '',
		showLoader: false,
		loaderMessage: 'Aguarde um momento...',
		status: '',
		token: localStorage.getItem('user-token') || '',
		user: localStorage.getItem('user') || "{}"
	},

	/**
	 * used for non async actions
	 */
	mutations: {
		AUTH_REQUEST(state) {
			state.status = 'loading'
		},
		AUTH_SUCCESS(state, { token, user }) {
			state.status = 'success'
			state.token = token
			state.user = user
		},
		AUTH_ERROR(state) {
			state.status = 'error'
		},
		LOGOUT(state) {
			state.status = ''
			state.token = ''
		},
		SHOW_SNACKBAR(state, message) {
			state.message = message
			state.show = true
		},
		CLOSE_SNACKBAR: (state) => {
			state.show = false
			state.message = ''
		},
		SHOW_LOADER(state, loaderMessage) {
			state.showLoader = true
			state.loaderMessage = loaderMessage || 'Aguarde um momento...'
		},
		CLOSE_LOADER(state) {
			state.showLoader = false
			state.loaderMessage = 'Aguarde um momento...'
		},
	},

	/**
	 * used for asycn actions, 
	 * when commit is called we are mutating some data
	 */
	actions: {
		login({ commit }, user) {
			return new Promise((resolve, reject) => {
				commit('AUTH_REQUEST')
				axios({
						url: 'http://localhost:8888/api/login',
						data: user,
						method: 'POST'
					})
					.then(resp => {
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
						axios.defaults.headers.common['Authorization'] = token
						commit('AUTH_SUCCESS',{ token, user })
						resolve(resp)
					})
					.catch(err => {
						console.log({ err })
						commit('AUTH_ERROR')
						localStorage.removeItem('user-token')
						localStorage.removeItem('user')
						reject(err)
					})
			})
		},
		logout({ commit }) {
			return new Promise((resolve) => {
				commit('LOGOUT')
				localStorage.removeItem('user-token')
				localStorage.removeItem('user')
				localStorage.removeItem('Authorization')
				delete axios.defaults.headers.common['Authorization']
				resolve()
			})
		},
		setToken({ commit }, validUser) {
			return new Promise((resolve) => {
				const token = 'Bearer  '.concat(validUser.token)
				const user = validUser
				const roles = user.authorities.map(role => role.authority)
				localStorage.setItem('user-token', token)
				let parsedUser = {
					user: user.username,
					roles,
					token
				}
				localStorage.setItem('user', JSON.stringify(parsedUser))
				axios.defaults.headers.common['Authorization'] = token
				commit('AUTH_SUCCESS', { token, user })
				resolve()
			})
		}
	},

	/**
	 * simple getters for fetch data inside the store 
	 * that is in state and is not a state variable 
	 * (when some manipulation is needed)
	 */
	getters: {
		isLoggedIn: state => !!state.token,
		authStatus: state => state.status,
    loggedUser: state => state.user ? state.user : null
	}
})
