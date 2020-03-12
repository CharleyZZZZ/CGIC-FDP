/**
 * 配置不同环境接口前缀
 * 如果未配置dev为默认配置
 * @param {*} base
 * @example
 * {
 *   dev: 'dev环境配置信息',
 *   test: 'test环境配置信息',
 *   prod: '线上环境配置信息'
 * }
 */
function conf (base = {}) {
  if (process.env.NODE_ENV === 'production') { // 生产环境下
    let env = process.env.ENV_CONFIG || 'dev'
    return base[env] || base['dev']
  }
  // 开发环境
  return base['dev']
}

// client_secret
// http://47.96.226.118/ 前端主页地址，logout
// 后台服务器地址在 Global.vue中配置
export const SERVER_BASE_URL = conf({
  dev: 'http://47.96.226.118',
  test: 'http://localhost',
  prod: 'http://localhost'
})

// client_id
export const CLIENT_ID = conf({
  dev: 'user_client',
  test: 'user_client',
  prod: 'user_client'
})

// client_secret
export const CLIENT_SECRET = conf({
  dev: 'user_secret',
  test: 'user_secret',
  prod: 'user_secret'
})
