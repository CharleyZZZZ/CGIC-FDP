import {setToken, removeToken, setUser, removeUser, setWaitType, removeWaitType, getUser, setRoleIds, removeRoleIds} from '@/api/auth'

function clearCookie () {
  let date = new Date()
  date.setTime(date.getTime() - 10000)
  let keys = document.cookie.match(/[^ =;]+(?=\=)/g)
  if (keys) {
    for (var i = keys.length; i--;)
      document.cookie = keys[i] + "=0; expire=" + date.toGMTString() + "; path=/"
  }
};

let user = {
  state: {
    token: '',
    userData: null,
    waitType: '',
    roles: []
  },
  mutations: {
    SET_TOKEN: (state, token) => {
      setToken(token)
      state.token = token
    },
    SET_USERDATA: (state, userData) => {
      setUser(userData)
      state.userData = userData
    },
    SET_ROLES: (state, roles) => {
      setRoleIds(JSON.stringify(roles))
      state.roles = roles
    },
    SET_WAITTYPE: (state, waitType) => {
      setWaitType(waitType)
      state.waitType = waitType
    },
    REMOVE_TOKEN: (state, skip) => {
      removeToken()
      removeUser()
      removeWaitType()
      removeRoleIds()
      clearCookie()
      state.token = ''
      state.userData = null
      state.waitType = ''
      state.roles = []
      // let url = `${POR_BASE_URL}/logout`
      // if (skip) {
      //   logoutByForm(url)
      // }
    }
  },
  actions: {
  }
}

export default user
