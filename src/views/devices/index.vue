<template>
  <div class="page">
    <el-table
      :key="tableKey"
      v-loading="listLoading"
      :data="dataList.records"
      border
      fit
      highlight-current-row
      style="width: 100%;"
    >
      <el-table-column label="设备id" width="150" prop="ideviceId" align="center" />
      <el-table-column label="设备名称" prop="sdriverName" align="center" />
      <el-table-column label="发动机编号" width="200" prop="iengineId" align="center" />
      <el-table-column label="制造厂商" width="300" prop="sfacturers" align="center" />
      <el-table-column label="联系电话" width="300" prop="sdriverPhone" align="center" />
    </el-table>

    <pagination
      v-show="dataList.total>0"
      :total="dataList.total"
      :page.sync="query.pageNo"
      :limit.sync="query.pageSize"
      @pagination="fetchPageList"
    />
  </div>
</template>

<script>
import Pagination from '@/components/Pagination'
import { getDevicePageList } from '@/api/device'

export default {
  name: 'Devices',
  components: { Pagination },

  data() {
    return {
      listLoading: true,
      tableKey: 0,
      dataList: {
        records: null,
        total: 0
      },
      query: {
        pageNo: 1,
        pageSize: 10
      }
    }
  },

  created() {
    this.fetchPageList()
  },

  methods: {
    async fetchPageList() {
      this.listLoading = true
      const { data } = await getDevicePageList(this.query)
      this.listLoading = false
      this.dataList = data
    }
  }
}
</script>

<style lang="scss" scoped>
.page{
  margin-top: 20px;
  padding: 20px;
}
</style>
