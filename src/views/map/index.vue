<template>
  <div class="page">
    <div class="date-picker">
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
    </div>

    <el-amap
      ref="map"
      map-style="amap://styles/62009be025f187dd3eafe327d2e55b8e"
      :center="map.center"
      :zoom="map.zoom"
      @init="onMapInit"
    >
      <el-amap-control-tool-bar />
      <el-amap-control-geolocation :offset="[20,90]" />
      <el-amap-marker
        v-if="marker.visible"
        ref="marker"
        :position="marker.position"
        :icon="marker.icon"
        @click="clickMarker"
      />
      <el-amap-polyline v-if="polyline.visible" :stroke-weight="8" :path="polyline.path" />
    </el-amap>
  </div>
</template>

<script>
import { getGpsList } from '@/api/gps'
import dayjs from 'dayjs'

// 默认开始日期和结束日期
const beginTime = dayjs().subtract(6, 'month').add(1, 'day').format('YYYY-MM-DD')
const endTime = dayjs().add(1, 'day').format('YYYY-MM-DD')

export default {
  name: 'Monitor',

  data() {
    return {
      dateValueArr: [beginTime, endTime],
      pickerOptions: {
        disabledDate(date) {
          return date > dayjs().add(1, 'day')
        }
      },
      query: {
        beginTime,
        endTime
      },
      map: { center: undefined, zoom: 20 },
      marker: {
        visible: false,
        position: [],
        icon: ''
        // icon: 'https://a.amap.com/jsapi_demos/static/demo-center-v2/car.png'
      },
      polyline: { visible: false, path: [] }
    }
  },

  methods: {
    /**
     * 时间选择回调
     * @param dateValueArr
     */
    onDateChange(dateValueArr) {
      this.query.beginTime = dateValueArr[0]
      this.query.endTime = dateValueArr[1]
      this.fetchList()
    },

    /**
     * map初始化回调
     * @param e AMap对象
     */
    onMapInit(e) {
      // 开启动画前需调用
      e.plugin('AMap.MoveAnimation', () => {
        this.fetchList()
      })
    },

    async fetchList() {
      const { data } = await getGpsList(this.query)
      const pathArr = []
      data.forEach(item => {
        if (item.flongitude > 0 && item.flongitude < 180 && item.flatitude > 0 && item.flatitude < 90) {
          // 剔除脏数据
          pathArr.push([item.flongitude, item.flatitude])
        }
      })

      if (pathArr.length) {
        this.polyline.path = pathArr
        this.map.zoom = 20
        this.marker.visible = this.polyline.visible = true
        this.map.center = this.marker.position = pathArr[pathArr.length - 1]
      } else {
        this.map.center = []
        this.map.zoom = 15
        this.marker.position = this.polyline.path = []
        this.marker.visible = this.polyline.visible = false
      }
    },

    clickMarker() {
      if (this.polyline.visible) {
        this.$refs.marker.$$getInstance().moveAlong(this.polyline.path, {
          // 每一段的时长
          duration: 100, // 可根据实际采集时间间隔设置
          // JSAPI2.0 是否延道路自动设置角度在 moveAlong 里设置
          autoRotation: true
        })
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.page {
  width: 100%;
  height: 90vh;
  position: relative;

  .date-picker {
    top: 20px;
    right: 20px;
    position: absolute;
    z-index: 999;
  }
}
</style>
