<template>
  <div id="title">
    <div class="my-title">
      {{ myTitle }}
    </div>
    <el-divider></el-divider>
  </div>
</template>
<script>
  export default {
    name: 'VTitle',
    props: {
      myTitle: String,
      required: true
    }
  }

</script>
<style scoped>
  .my-title {
    text-align: left;
    font-size: 22px;
    width: 100%;
    font-weight: 600;
    color: #337ab7;
  }

  .my-title::before {
    content: "0";
    background-color: #337ab7;
    font-size: 14px;
    color: #337ab7;
  }

  .el-divider--horizontal {
    margin: 8px 0;
  }

</style>
