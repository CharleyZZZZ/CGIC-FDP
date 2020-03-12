import Cookies from 'js-cookie'

const TokenKey = 'UserToken'
const UserDetail = 'UserDetail'
const RoleIds = 'RoleIds'
const WaitType = 'WaitType'


export function getToken () {
  return Cookies.get(TokenKey)
}

export function setToken (token) {
  return Cookies.set(TokenKey, token, { path: '' })
}

export function removeToken () {
  return Cookies.remove(TokenKey, { path: '' })
}

export function getUser () {
  return Cookies.get(UserDetail)
}

export function setUser (data) {
  return Cookies.set(UserDetail, data, { path: '' })
}

export function removeUser () {
  return Cookies.remove(UserDetail, { path: '' })
}

export function getWaitType () {
  return Cookies.get(WaitType)
}

export function setWaitType (data) {
  return Cookies.set(WaitType, data, { path: '' })
}

export function removeWaitType () {
  return Cookies.remove(WaitType, { path: '' })
}

export function getRoleIds () {
  return Cookies.get(RoleIds)
}

export function setRoleIds (data) {
  return Cookies.set(RoleIds, data, { path: '' })
}

export function removeRoleIds () {
  return Cookies.remove(RoleIds, { path: '' })
}
