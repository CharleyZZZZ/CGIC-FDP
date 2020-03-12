import Vue from 'vue'
import Router from 'vue-router'
import store from '@/store'


Vue.use(Router)

export const routerMap = [
  {
    path: '/',
    name: 'login',
    redirect: '/loginB'
  },
  {
    path: '/loginA',
    component: resolve => require(['@/components/LoginA'], resolve)
  },
  {
    path: '/loginB',
    component: resolve => require(['@/components/LoginB'], resolve)
  },
  {
    path: '/loginC',
    component: resolve => require(['@/components/LoginC'], resolve)
  },
  {
    path: '/main',
    component: resolve => require(['@/components/Index'], resolve),
    children: [
      {
        path: 'indexpage',
        component: resolve => require(['@/components/page/IndexPage'], resolve)
      },
      {
        path: 'menumgt',
        component: resolve => require(['@/components/page/MenuManagement'], resolve)
      }
    ]
  }
]

const router = new Router({
  mode: 'history',
  scrollBehavior: () => ({y: 0}),
  routes: routerMap
})

router.beforeEach((to, from, next) => {
  let token = store.getters.token
    if (!token) {
      if(to.path != '/loginB') {
        next({path: '/'})
      }else{
        next()
      }
    } else {
      if(to.path === '/loginB'){
        next({path: '/main/indexpage'})
      }else{
        // validateToken().then((res) => {
        //   if (res.fromSystem === 'N') {
        //     store.commit('SET_WAITTYPE', 'BPM')
        //   } else {
        //     store.commit('SET_WAITTYPE', 'PORTAL')
        //   }
        //   if (getUser()) {
        //     let userData = JSON.parse(getUser())
        //     document.title = userData.mainName
        //   }
          next()
        // }).catch((err) => {
        //   if (err.response.status === 401) store.commit('REMOVE_TOKEN', true)
        // })
      }


  }

})

export default router
