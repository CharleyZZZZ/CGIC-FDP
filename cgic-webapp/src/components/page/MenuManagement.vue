<template>
  <div id="menumgt">
    <v-title :myTitle="myTitle"></v-title>
    <div>
      <el-row>
        <el-button type="primary" size="mini" @click="dialogVisible = true">新增</el-button>
      </el-row>
      <el-row>
        <el-table
          :data="menuData"
          style="width: 100%">
          <el-table-column
            prop="menuId"
            label="ID"
            width="80">
          </el-table-column>
          <el-table-column
            prop="menuCode"
            label="菜单编码"
            width="100">
          </el-table-column>
          <el-table-column
            prop="menuName"
            label="菜单名称">
          </el-table-column>
          <el-table-column
            prop="resourceId"
            label="资源名称">
          </el-table-column>
          <el-table-column
            prop="parentId"
            label="父级菜单">
          </el-table-column>
          <el-table-column
            prop="menuOrder"
            label="排序">
          </el-table-column>
          <el-table-column
            prop="isEnabeld"
            label="是否启用">
          </el-table-column>
        </el-table>
      </el-row>

    </div>



    <el-dialog
      title="新增菜单"
      :visible.sync="dialogVisible"
      width="60%"
      :before-close="handleClose">

      <el-form>
        <el-row>
          <el-col :span="4" :offset="1">
            <label class="el-form-label">菜单编码</label>
          </el-col>
          <el-col :span="6">
            <el-input v-model="addMenu.menuCode"></el-input>
          </el-col>
          <el-col :span="4">
            <label class="el-form-label">菜单名称</label>
          </el-col>
          <el-col :span="6">
            <el-input v-model="addMenu.menuName"></el-input>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="4" :offset="1">
            <label class="el-form-label">资源ID</label>
          </el-col>
          <el-col :span="6">
            <el-input v-model="addMenu.resourceId"></el-input>
          </el-col>
          <el-col :span="4">
            <label class="el-form-label">父菜单ID</label>
          </el-col>
          <el-col :span="6">
            <el-input v-model="addMenu.parentId"></el-input>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="4" :offset="1">
            <label class="el-form-label">菜单排序</label>
          </el-col>
          <el-col :span="6">
            <el-input v-model="addMenu.menuOrder"></el-input>
          </el-col>
          <el-col :span="4">
            <label class="el-form-label">是否启用</label>
          </el-col>
          <el-col :span="6">
            <el-input v-model="addMenu.isEnabled" type="checkbox"></el-input>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="4" :offset="1">
            <label class="el-form-label">描述</label>
          </el-col>
          <el-col :span="16">
            <el-input type="textarea" placeholder="请输入描述" rows="12"></el-input>
          </el-col>
        </el-row>


      </el-form>

      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import VTitle from '../commons/VTitle.vue'
  import ElButton from '../../../node_modules/element-ui/packages/button/src/button.vue'
  import ElDialog from '../../../node_modules/element-ui/packages/dialog/src/component.vue'
  import ElForm from '../../../node_modules/element-ui/packages/form/src/form.vue'
  import ElInput from '../../../node_modules/element-ui/packages/input/src/input.vue'
  import ElDropdownItem from '../../../node_modules/element-ui/packages/dropdown/src/dropdown-item.vue'
  import ElDivider from '../../../node_modules/element-ui/packages/divider/src/main.vue'
  import ElRow from 'element-ui/packages/row/src/row'

  export default {
    components: {
      ElRow,
      ElDivider,
      ElDropdownItem,
      ElInput,
      ElForm,
      ElDialog,
      ElButton,
      VTitle
    },
    name: 'MenuManagement',
    data () {
      return {
        myTitle: '菜单管理',
        dialogVisible: false,
        addMenu: {
          menuCode: '',
          menuName: '',
          description: '',
          resourceId: null,
          parentId: null,
          menuOrder: null,
          isEnabled: ''
        },
        menuData:[]
      }
    },
    methods: {
      handleClose () {
        this.dialogVisible = false
      }
    }
  }
</script>
<style scoped>
  #menumgt >>> .el-dialog__header {
    border-bottom: 1px solid #ece9e9;
    margin: 0px 10px;
  }

  .el-form-label {
    color: #000;
    height: 32px;
    line-height: 32px;
    float: right;
    font-size: 16px;
    margin-right: 10px;
  }

  .el-row {
    margin: 16px 6px;
  }

</style>

