import {getToken, getWaitType} from '@/api/auth'
let getters = {
  token: state => state.user.token || getToken(),
  userData: state => state.user.userData,
  waitType: state => state.user.waitType || getWaitType(),
  roles: state => state.user.roles
}
export default getters
