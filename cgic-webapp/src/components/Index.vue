<template>
  <div id="wrapper">
    <v-header></v-header>
    <el-container class="container">
      <el-aside class="left" :style="{ height: screenHeight + 'px' }">
        <v-menu :active.sync="active"></v-menu>
      </el-aside>

      <div class="right">
        <router-view></router-view>
      </div>
    </el-container>

  </div>
</template>
<script>

  import VMenu from "./commons/VMenu.vue";
  import VHeader from "./commons/VHeader.vue";

  export default {
    components: {
      VHeader, VMenu
    },
    data() {
      return {
        active: 'pageindex',
        screenHeight: 800
      }
    },
    mounted() {
      const that = this;
      window.screenHeight = document.body.clientHeight;
      that.screenHeight = window.screenHeight - 60;
    },
    watch: {
      active(newVal) {
        console.log(newVal);
        this.$router.push({
          path: '/main/' + `${this.active}`
        })
      }
    },
    methods: {}
  };
</script>

<style>
  body {
    margin: 0px;
  }

  /* 所有 */
  #wrapper {
    width: 100%;
    height: 100%;
  }

  /* 内容区 */
  .container {
    min-height: 600px;
    width: 100%;
  }

  /* 左边内容区 */
  .left {
    color: #4b595f;
    background-color: rgb(39, 45, 52);
    width: 200px;
  }

  /* 右边内容区 */
  .right {
    width: 100%;
    background-color: #eaf1f194;
    padding: 5px;
  }

  tbody {
    font-size: 15px;
    color: #4b595f;
  }

</style>
