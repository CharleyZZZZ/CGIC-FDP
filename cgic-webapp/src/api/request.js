import axios from 'axios'
import store from '@/store'

// 获取token专用
export const loginApi = axios.create({
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded'
  }
})

// 获取用户信息
export const userInfoApi = axios.create({
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded'
  }
})

// request 拦截器
const requestInterceptor = config => {
  console.log('get store token :' + store.getters.token)
  if (store.getters.token) {
      config.headers.Authorization = `Bearer ${store.getters.token}`
      console.log(config.headers)
  }
  return config
}

const errorRequestInterceptor = (error) => {
  Promise.reject(error)
}
//
// // login response拦截器
// const loginResponseInterceptor = response => {
//   const res = response.data
//   if (res) {
//     return res
//   }
// }
//
// const errorResponseInterceptor = (error) => {
//   console.log('err：' + JSON.stringify(error))
//   if (error.response) {
//     switch (error.response.status) {
//       // token失效 重新获取
//       case 401:
//         store.commit('REMOVE_TOKEN', true)
//         break
//       case 404:
//         Message({
//           message: `未知错误！`,
//           type: 'error',
//           duration: 5 * 1000
//         })
//         break
//       default:
//         Message({
//           message: `${error.response.message}`,
//           type: 'error',
//           duration: 5 * 1000
//         })
//     }
//   } else {
//     if (error.code === 'ECONNABORTED' && error.message.indexOf('timeout') !== -1) {
//       Message({
//         message: '网络请求超时！',
//         type: 'error',
//         duration: 5 * 1000
//       })
//     } else {
//       Message({
//         message: '发生未知错误，请联系管理员！',
//         type: 'error',
//         duration: 5 * 1000
//       })
//     }
//   }
//   return Promise.reject(error)
// }
//
// // response拦截器
// const responseInterceptor = response => {
//   const res = response.data
//   if (!res.success) {
//     console.log(res)
//     Message({
//       message: res.success === false ? `${res.message}` : '发生未知错误，请联系管理员！',
//       type: 'error',
//       duration: 5 * 1000
//     })
//     // eslint-disable-next-line
//     return Promise.reject('error')
//   } else {
//     return res
//   }
// }
//
// loginApi.interceptors.response.use(loginResponseInterceptor, errorResponseInterceptor)
userInfoApi.interceptors.request.use(requestInterceptor, errorRequestInterceptor)
