<template>
  <div>
    <el-row>
      <el-col :span="24">
        <div class="block">
          <el-carousel style="height: 300px;">
            <el-carousel-item v-for="(item,index) in sliders" :key="index">
              <img  :src="item.img" style="width: 100%;height: 100%" alt="">
            </el-carousel-item>
          </el-carousel>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>代办事项</span>
            <el-button style="float: right; padding: 3px 0" type="text" @click="dialogVisible = true">操作按钮</el-button>
          </div>
          <div v-for="o in 6" :key="o" class="text item">
            {{'代办事项 ' + o }}
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-calendar v-model="currentDate"></el-calendar>
      </el-col>
    </el-row>


    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>


</template>
<script>
  import ElCalendar from "../../../node_modules/element-ui/packages/calendar/src/main.vue";
  import ElImage from "../../../node_modules/element-ui/packages/image/src/main.vue";

  export default {
    components: {
      ElImage,
      ElCalendar
    },
    name: "IndexPage",
    data() {
      return {
        currentDate: new Date(),
        sliders:[
          {
            img:'http://101.133.160.225/carousel/001.jpg'
          },
          {
            img:'http://101.133.160.225/carousel/002.jpg'
          },
          {
            img:'http://101.133.160.225/carousel/003.jpg'
          },
          {
            img:'http://101.133.160.225/carousel/004.jpg'
          }
        ],
        dialogVisible: false
      }
    },
    mounted(){

    },
    methods: {
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {
          });
      }
    }
  }
</script>

<style scoped>

  /*穿透*/
  /*calendar*/
  .el-calendar >>> .el-calendar-table .el-calendar-day {
    height: 45px;
  }

  .el-calendar {
    -webkit-box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .1);
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .1);
  }

  /*carousel*/
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .el-col {
    padding: 4px;
  }

  /*card*/
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    height: 418px;
  }
</style>
