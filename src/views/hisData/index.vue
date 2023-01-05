<template>
  <div class="page">
    <div class="search-filter">
      <span>时间筛选:</span>
      <el-date-picker
        v-model="dateValueArr"
        :picker-options="pickerOptions"
        type="daterange"
        range-separator="至"
        unlink-panels
        :clearable="false"
        value-format="yyyy-MM-dd"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
        style="width:300px;margin-left: 10px"
        @change="onDateChange"
      />

      <span style="margin-left: 50px">类型筛选:</span>
      <el-select v-model="selValue" placeholder="请选择监测类型" style="margin-left: 10px" @change="onChange">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        />
      </el-select>
    </div>

    <el-row style="background:#fff;padding:16px 16px 0;margin:20px 0 32px 0;">
      <line-chart v-if="selValue===0" :chart-data="hallLineChartData" height="600px" />
      <line-chart v-if="selValue===1" :chart-data="temperatureLineChartData" height="600px" />
      <line-chart v-if="selValue===2" :chart-data="coLineChartData" height="600px" />
      <line-chart v-if="selValue===3" :chart-data="fireLineChartData" height="600px" />
      <line-chart v-if="selValue===4" :chart-data="waterLineChartData" height="600px" />
    </el-row>
  </div>
</template>

<script>
import LineChart from './components/LineChart'
import { getHallHisData } from '@/api/hall'
import { getTemperatureHisData } from '@/api/temperature'
import { getCoHisData } from '@/api/co'
import { getFireHisData } from '@/api/fire'
import { getWaterHisData } from '@/api/water'
import dayjs from 'dayjs'

// 默认开始日期和结束日期
const beginTime = dayjs().subtract(6, 'month').add(1, 'day').format('YYYY-MM-DD')
const endTime = dayjs().add(1, 'day').format('YYYY-MM-DD')

export default {
  name: 'HisData',
  components: {
    LineChart
  },

  data() {
    return {
      options: [
        { label: '转速', value: 0 },
        { label: '温度', value: 1 },
        { label: 'CO', value: 2 },
        { label: '火焰', value: 3 },
        { label: '水位', value: 4 }
      ],
      selValue: 0,
      query: {
        beginTime,
        endTime
      },
      dateValueArr: [beginTime, endTime],
      pickerOptions: {
        disabledDate(date) {
          return date > dayjs().add(1, 'day')
        }
      },
      hallLineChartData: { title: '转速', color: '#40c9c6', xDatas: [], yDatas: [] },
      temperatureLineChartData: { title: '温度', color: '#36a3f7', xDatas: [], yDatas: [] },
      coLineChartData: { title: 'CO', color: '#c09b25', xDatas: [], yDatas: [] },
      fireLineChartData: { title: '火焰', color: '#e11436', xDatas: [], yDatas: [] },
      waterLineChartData: { title: '水位', color: '#447e1f', xDatas: [], yDatas: [] }
    }
  },

  created() {
    this.refreshData()
  },

  methods: {
    /** 类型选择 */
    onChange() {
      this.refreshData()
    },

    /**
     * 时间选择回调
     * @param dateValueArr
     */
    onDateChange(dateValueArr) {
      this.query.beginTime = dateValueArr[0]
      this.query.endTime = dateValueArr[1]
      this.refreshData()
    },

    refreshData() {
      switch (this.selValue) {
        case 0:
          this.fetchHallHisData()
          break
        case 1:
          this.fetchTemperatureHisData()
          break
        case 2:
          this.fetchCoHisData()
          break
        case 3:
          this.fetchFireHisData()
          break
        case 4:
          this.fetchWaterHisData()
          break
      }
    },

    async fetchHallHisData() {
      const { data } = await getHallHisData(this.query)
      this.hallLineChartData.xDatas = []
      this.hallLineChartData.yDatas = []
      data.forEach(item => {
        this.hallLineChartData.xDatas.push(item.stime)
        this.hallLineChartData.yDatas.push(item.ihall)
      })
    },

    async fetchTemperatureHisData() {
      const { data } = await getTemperatureHisData(this.query)
      this.temperatureLineChartData.xDatas = []
      this.temperatureLineChartData.yDatas = []
      data.forEach(item => {
        this.temperatureLineChartData.xDatas.push(item.stime)
        this.temperatureLineChartData.yDatas.push(item.ftemperature)
      })
    },

    async fetchCoHisData() {
      const { data } = await getCoHisData(this.query)
      this.coLineChartData.xDatas = []
      this.coLineChartData.yDatas = []
      data.forEach(item => {
        this.coLineChartData.xDatas.push(item.stime)
        this.coLineChartData.yDatas.push(item.fcoGas)
      })
    },

    async fetchFireHisData() {
      const { data } = await getFireHisData(this.query)
      this.fireLineChartData.xDatas = []
      this.fireLineChartData.yDatas = []
      data.forEach(item => {
        this.fireLineChartData.xDatas.push(item.stime)
        this.fireLineChartData.yDatas.push(item.ifire)
      })
    },

    async fetchWaterHisData() {
      const { data } = await getWaterHisData(this.query)
      this.waterLineChartData.xDatas = []
      this.waterLineChartData.yDatas = []
      data.forEach(item => {
        this.waterLineChartData.xDatas.push(item.stime)
        this.waterLineChartData.yDatas.push(item.fwaterLevel)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.page {
  padding: 32px;
  min-height: 90vh;
  background-color: rgb(242, 245, 240);

  .chart {
    margin-top: 30px;
  }
}
</style>
