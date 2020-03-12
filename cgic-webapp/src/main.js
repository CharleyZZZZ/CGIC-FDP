import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import store from './store'
import global_ from './Global.vue'

import {
  Select, Option, Col, Row, Button,
  ButtonGroup, Card,
  Table, TableColumn, Carousel,
  CarouselItem, Dropdown, DropdownMenu, Rate,
  DropdownItem, Dialog, Input, Form, FormItem, Scrollbar, Upload,
  DatePicker, Pagination, Tooltip, Checkbox, CheckboxGroup, Tree,
  Menu, Aside,Container,MenuItem,MenuItemGroup,Submenu,
  Loading, MessageBox, Notification, Message
} from 'element-ui'
import CollapseTransition from 'element-ui/lib/transitions/collapse-transition'
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/base.css'

// 按需加载
Vue.use(Select)
Vue.use(Option)
Vue.use(Col)
Vue.use(Row)
Vue.use(Button)
Vue.use(Table)
Vue.use(Scrollbar)
Vue.use(TableColumn)
Vue.use(Carousel)
Vue.use(CarouselItem)
Vue.use(Dropdown)
Vue.use(DropdownMenu)
Vue.use(DropdownItem)
Vue.use(Rate)
Vue.use(Dialog)
Vue.use(Input)
Vue.use(Form)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Submenu)
Vue.use(Menu)
Vue.use(FormItem)
Vue.use(DatePicker)
Vue.use(Pagination)
Vue.use(Tooltip)
Vue.use(Checkbox)
Vue.use(CheckboxGroup)
Vue.use(Upload)
Vue.use(Tree)
Vue.use(Aside)
Vue.use(Container)
Vue.use(Loading.directive)
Vue.use(ButtonGroup)
Vue.use(Card)
Vue.prototype.$loading = Loading.service
Vue.prototype.$msgbox = MessageBox
Vue.prototype.$alert = MessageBox.alert
Vue.prototype.$confirm = MessageBox.confirm
Vue.prototype.$prompt = MessageBox.prompt
Vue.prototype.$notify = Notification
Vue.prototype.$message = Message

// import VueTour from 'vue-tour'
// Vue.use(VueTour)

import VueParticles from 'vue-particles'

Vue.use(VueParticles)

// Font Awesome 图表库
// import 'font-awesome/css/font-awesome.css'

Vue.config.productionTip = false
Vue.prototype.$axios = axios

Vue.prototype.GLOBAL = global_
axios.defaults.baseURL = global_.BASE_URL

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: {App},
  template: '<App/>'
})
