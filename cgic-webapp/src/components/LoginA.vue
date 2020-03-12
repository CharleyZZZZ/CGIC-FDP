<template>
  <div id="login" >

    <vue-particles
      color="#fff"
      shapeType="circle"
      linesColor="#fff"
      style="height: 100%;width: 100%;position: absolute;z-index: 1"
    >
    <!--<vue-particles-->
      <!--color="#fff"-->
      <!--:particleOpacity="0.7"-->
      <!--:particlesNumber="60"-->
      <!--shapeType="circle"-->
      <!--:particleSize="4"-->
      <!--linesColor="#fff"-->
      <!--:linesWidth="1"-->
      <!--:lineLinked="true"-->
      <!--:lineOpacity="0.4"-->
      <!--:linesDistance="150"-->
      <!--:moveSpeed="2"-->
      <!--:hoverEffect="true"-->
      <!--hoverMode="grab"-->
      <!--:clickEffect="true"-->
      <!--clickMode="push"-->
      <!--z-index="1"-->
      <!--style="height: 100%;width: 100%;position: absolute;"-->
    <!--&gt;-->
    </vue-particles>

    <div style="z-index:99;position: relative">
      <div style="background-color: #000;height: 60px"></div>


      <img src="../assets/logo.png"
           :class="{'state-A-bg-image' : stateA, 'state-B-bg-image': stateB,'animation-state-A-bg-image' : animationA, 'animation-state-B-bg-image': animationB}"
           @click="animation" >

      <div id="login-box" v-if="isShowContent" >
        <!-- 通过:rules="loginFormRules"来绑定输入内容的校验规则 -->
        <el-form  ref="loginForm" :model="loginForm" label-position="right" label-width="auto"
                 show-message>
          <div style="margin-top: 26px"></div>
          <el-form-item label="用户名" prop="loginName">
            <el-col :span="22">
              <el-input type="text" v-model="loginForm.loginName" @input="userChange"  @keyup.enter.native="loginSubmit"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item label="密码" prop="loginPassword">
            <el-col :span="22">
              <el-input type="password" v-model="loginForm.loginPassword"  @input="userChange"  @keyup.enter.native="loginSubmit"></el-input>
            </el-col>
            <el-col :span="22"  class="error-msg">
              {{ errorMsg }}
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-button size="medium" type="primary" @click="loginSubmit" style="margin-left: -48px">登录
            </el-button>
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
    name: 'LoginA',
    components: {ElFormItem},
    data () {
      return {
        loginForm: {
          loginName: '',
          loginPassword: ''
        },
        stateA: true,
        stateB: false,
        animationA: false,
        animationB: false,
        isShowContent: false,
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
      animation () {
        if (this.isOpen) {
          this.animationA = true
          this.animationB = false
          this.stateA = false
          this.stateB = true
          this.isShowContent = true
          this.isOpen = false
        } else {
          this.animationB = true
          this.animationA = false
          this.stateA = true
          this.stateB = false
          this.isShowContent = false
          this.isOpen = true
        }

      }
    }
  }
</script>
<style scoped>
  #login-box >>> .el-form-item__label{
    color:#fff;
  }

  .login-title {
    text-align: center;
    margin: 0 auto 40px auto;
    color: #66CD00;
    font-size: 30px;
    font-weight: bold;
  }

  @keyframes fade-in {
    0% {
      opacity: 0;
    }
    /*初始状态 透明度为0*/
    40% {
      opacity: 0;
    }
    /*过渡状态 透明度为0*/
    100% {
      opacity: 1;
    }
    /*结束状态 透明度为1*/
  }

  @-webkit-keyframes fade-in { /*针对webkit内核*/
    0% {
      opacity: 0;
    }
    40% {
      opacity: 0;
    }
    100% {
      opacity: 1;
    }
  }

  #login-box {
    animation: fade-in; /*动画名称*/
    animation-duration: 1.75s; /*动画持续时间*/
    -webkit-animation: fade-in 1.75s; /*针对webkit内核*/
    border: 1px solid #9e9fa2;
    width: 350px;
    margin-left: 50%;
    left: -211px;
    top: 340px;
    padding: 35px 35px 15px 35px;
    border-radius: 5px;
    position: absolute;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    box-shadow: 0 0 10px #b8e0fb;
    z-index:99;
  }

  #login {
    height:100%;
    width: 100%;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    background:#48485d;
  }

  /* img的A状态 */

  .state-A-bg-image {
    opacity: 1;
    top: 260px;
    position: absolute;
    width: 300px;
    left: -150px;
    margin-left: 50%;
  }

  /* img的A状态动画设置 */

  .animation-state-A-bg-image {
    animation-name: animation_A-bg-image;
    animation-duration: 1.25s;
  }

  /* img的A状态关键帧(从A状态到B状态) */

  @keyframes animation_A-bg-image {
    from {
      opacity: 1;
      top: 260px;
      position: absolute;
      width: 300px;
      left: -150px;
      margin-left: 50%;
    }
    to {
      opacity: 1;
      top: 180px;
      position: absolute;
      width: 180px;
      left: -90px;
      margin-left: 50%;
    }
  }

  /*======================== B状态 ========================*/

  /* img的B状态 */

  .state-B-bg-image {
    opacity: 1;
    top: 180px;
    position: absolute;
    width: 180px;
    left: -90px;
    margin-left: 50%;
  }

  /* img的B状态动画设置 */

  .animation-state-B-bg-image {
    animation-name: animation_B-bg-image;
    animation-duration: 1.25s;
  }

  /* img的B状态关键帧(从B状态到A状态) */

  @keyframes animation_B-bg-image {
    from {
      opacity: 1;
      top: 180px;
      position: absolute;
      width: 180px;
      left: -90px;
      margin-left: 50%;
    }
    to {
      opacity: 1;
      top: 260px;
      position: absolute;
      width: 300px;
      left: -150px;
      margin-left: 50%;
    }
  }

  .error-msg {
    text-align: left;
    color: red;
    font-size: 12px;
  }

</style>
