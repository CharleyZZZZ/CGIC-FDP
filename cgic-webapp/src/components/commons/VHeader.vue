<template>
  <div>
    <el-header class="header">
      <div class="title">
        <router-link to="/" id="title-link"><span>CGIC快捷开发平台</span></router-link>
        <a id="login-user" @click="showUserWindow">
          <img class="rounded-circle" src="@/assets/user-01.png"></img>
        </a>
        <div id="flaot-win" v-show="isShowUserWindow">
          <div class="login-user">{{ loginUserName }}</div>
          <div class="dropdown-divider"></div>
          <a class="user-btn">
            个人信息 <i class="el-icon-user"/>
          </a>
          <a class="user-btn" @click="logoutAction">
            退出登录 <i class="el-icon-eleme"/>
          </a>
        </div>
      </div>
    </el-header>
  </div>
</template>
<script>
  import ElHeader from '../../../node_modules/element-ui/packages/header/src/main.vue'
  import ElImage from '../../../node_modules/element-ui/packages/image/src/main.vue'
  import { getUser, removeUser, removeRoleIds, removeToken } from '@/api/auth'
  import { SERVER_BASE_URL } from '@/api/config'

  export default {
    name: 'VHeader',
    components: {
      ElImage,
      ElHeader
    },
    data () {
      return {
        isShowUserWindow: false,
        loginUserName: '游客'
      }
    },
    mounted () {
      this.loginUserName = getUser() ? JSON.parse(getUser()).displayName : this.$store.getters.userData.displayName
    },
    methods: {
      showUserWindow: function () {
        this.isShowUserWindow = !this.isShowUserWindow
      },
      logoutAction: function () {
        removeUser();
        removeRoleIds();
        removeToken();
        window.location.href = `${SERVER_BASE_URL}`
      }
    }
  }
</script>

<style>

  a:hover {
    text-decoration: none;
  }

  #title-link {
    color: #fff;
    float: left;
  }

  /* 头 */
  .header {
    color: rgba(255, 255, 255, 0.75);
    line-height: 60px;
    background-color: #0a77ab;
    text-align: center;
    font-size: 24px;
    width: 100%;
  }

  .header div {
    display: block;
    width: 100%;
  }

  .title {
    float: left;
  }

  .author {
    float: right;
  }

  .author-img {
    width: 20px;
    height: 20px;
  }

  .author-github {
    cursor: pointer;
  }

  #login-user {
    float: right;
    padding-left: .75em;
    padding-right: .75em;
    height: 40px;
    padding-top: 10px;
    cursor: pointer;
  }

  .rounded-circle {
    border-radius: 50% !important;
    width: 40px;
    height: 40px;
  }

  div#flaot-win {
    background: #fff;
    width: 120px;
    position: absolute;
    z-index: 100;
    right: 52px;
    top: 52px;
    color: #000;
    font-size: 14px;
    border-radius: 3px;
    border: solid 1px #e9ecef;

  }

  #flaot-win .login-user {
    height: 40px;
    line-height: 40px;
    text-align: center;
    font-weight: 700;
  }

  #flaot-win .user-btn {
    display: block;
    height: 30px;
    line-height: 30px;
    text-align: center;
    padding: 5px;
    cursor: pointer;
  }

  #flaot-win .dropdown-divider {
    height: 0;
    overflow: hidden;
    border-top: 1px solid #e9ecef;
  }

  .user-btn:focus, .user-btn:hover {
    color: #16181b;
    text-decoration: none;
    background-color: #f8f9fa;
  }

</style>
