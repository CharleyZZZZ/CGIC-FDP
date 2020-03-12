<template>
  <div id="login">

    <vue-particles
      color="#fff"
      shapeType="circle"
      linesColor="#fff"
      style="position: absolute;height: 100%;width: 100%;z-index: 1;">
    </vue-particles>

    <div style="z-index:99;position: relative">
      <div id="title-box">
        <img class="title-img" src="../assets/logo.png"/>
        <ol class="title-ol">
          <li>CGIC</li>
          <li>声明</li>
          <li>关于</li>
        </ol>
      </div>

      <div id="login-box">
        <el-form ref="loginForm" :model="loginForm" label-position="right" label-width="auto"
                 show-message>
          <div style="margin-top: 26px"></div>
          <el-form-item prop="loginName">
            <el-col :span="18" :offset="3">
              <el-input type="text" v-model="loginForm.loginName" @input="userChange"  @keyup.enter.native="loginSubmit"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item  prop="loginPassword">
            <el-col :span="18" :offset="3">
              <el-input type="password" v-model="loginForm.loginPassword" @input="userChange"  @keyup.enter.native="loginSubmit"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="18" :offset="3">
              <el-button size="medium" type="primary" @click="loginSubmit" style="width: 100%">登录
              </el-button>
            </el-col>
            <el-col :span="18" :offset="3" class="error-msg">
              {{ errorMsg }}
            </el-col>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>
<script type="text/javascript">
  import store from '@/store'
  import { getToken, getUserDetail } from '@/api/api'
  import ElFormItem from '../../node_modules/element-ui/packages/form/src/form-item.vue'

  export default {
    name: 'LoginC',
    components: {ElFormItem},
    data () {
      return {
        loginForm: {
          loginName: '',
          loginPassword: ''
        },
        isOpen: true,
        errorMsg: ''
      }
    }, methods: {
      loginSubmit () {
        let _data = {
          username: this.loginForm.loginName,
          password: this.loginForm.loginPassword
        }
        getToken(_data).then((res) => {
          let token = res.data.access_token
          store.commit('SET_TOKEN', token)
//          store.commit('SET_ROLES', res.roleIds)
          getUserDetail().then((res) => {
            if (res.data.rows && res.data.rows.length > 0) {
              let _data = {
                username: res.data.rows[0].username,
                userId: res.data.rows[0].userId,
                displayName: res.data.rows[0].displayName,
                email: res.data.rows[0].email,
                phone: res.data.rows[0].phone,
                employeeId: res.data.rows[0].employeeId
              }
              store.commit('SET_USERDATA', _data)
              this.$router.push({path: '/main/indexpage'})
            } else {
              this.$message.error('用户信息获取失败')
            }
          }).catch((e) => {
            console.log(e)
          })
        }).catch((e) => {
          this.errorMsg = '用户名或密码错误.'
          console.log(e)
        })

      },
      userChange () {
        this.errorMsg = ''
      },

    }
  }
</script>
<style scoped>
  #login-box >>> .el-form-item__label {
    color: #fff;
  }

  #login-bmg{
    /*opacity: 0.8;*/
    height: 100%;
    width: 100%;
    position: absolute;
    /*left: 0;*/
    /*top:0;*/
    z-index: 1;
  }

  #title-box {
    height: 80px;
    border-bottom: 1px solid hsla(0,0%,100%,.1);
  }

  #title-box .title-img{
    height: 60px;
    float: left;
    margin-top:14px;
    margin-left: 140px;
  }

  #title-box .title-ol{
    float: right;
    margin-right: 140px;
    margin-top: 24px;
  }


  ol li{
    display: inline-block;
    margin-right: 30px;
    font-size: 24px;
    color:#ffffff74;
  }

  #login-box {
    animation: fade-in; /*动画名称*/
    animation-duration: 1.75s; /*动画持续时间*/
    -webkit-animation: fade-in 1.75s; /*针对webkit内核*/
    border: 1px solid #9e9fa2;
    width: 350px;
    margin-left: 74%;
    left: -211px;
    top: -200px;
    margin-top: 38%;
    padding: 30px;
    border-radius: 5px;
    position: absolute;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    box-shadow: 0 0 10px #b8e0fb;
    z-index: 99;
  }

  #login {
    height: 100%;
    width: 100%;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    background-color: rgb(39, 45, 52);
  }

  .error-msg {
    text-align: left;
    color: red;
    font-size: 12px;
  }

</style>
