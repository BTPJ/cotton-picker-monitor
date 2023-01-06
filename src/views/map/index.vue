<template>
  <div id="container">
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
        ref="marker"
        :position="marker.position"
        :icon="marker.icon"
        @click="clickMarker"
      />
      <el-amap-polyline :stroke-weight="8" :visible="polyline.visible" :path="polyline.path" />
    </el-amap>
  </div>
</template>

<script>
import { getGpsList } from '@/api/gps'

export default {
  name: 'Monitor',

  data() {
    return {
      map: { center: undefined, zoom: 20 },
      marker: {
        position: [116.478935, 39.997761],
        icon: ''
        // icon: 'https://a.amap.com/jsapi_demos/static/demo-center-v2/car.png'
      },
      polyline: { path: [[116.478935, 39.997761], [116.478939, 39.997825]] },
      lineArr: [[116.478935, 39.997761], [116.478939, 39.997825], [116.478912, 39.998549], [116.478912, 39.998549], [116.478998, 39.998555], [116.478998, 39.998555], [116.479282, 39.99856], [116.479658, 39.998528], [116.480151, 39.998453], [116.480784, 39.998302], [116.480784, 39.998302], [116.481149, 39.998184], [116.481573, 39.997997], [116.481863, 39.997846], [116.482072, 39.997718], [116.482362, 39.997718], [116.483633, 39.998935], [116.48367, 39.998968], [116.484648, 39.999861]]
    }
  },

  methods: {
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
      const { data } = await getGpsList()
      const pathArr = []
      data.forEach(item => {
        if (item.flongitude > 0 && item.flongitude < 180 && item.flatitude > 0 && item.flatitude < 90) {
          // 剔除脏数据
          pathArr.push([item.flongitude, item.flatitude])
        }
      })

      this.polyline.path = pathArr
      this.map.center = this.marker.position = pathArr[pathArr.length - 1]
    },

    clickMarker() {
      console.log(this.$refs.marker.$$getInstance())
      this.$refs.marker.$$getInstance().moveAlong(this.polyline.path, {
        // 每一段的时长
        duration: 100, // 可根据实际采集时间间隔设置
        // JSAPI2.0 是否延道路自动设置角度在 moveAlong 里设置
        autoRotation: true
      })
    }
  }
}
</script>

<style lang="scss" scoped>
#container {
  width: 100%;
  height: 90vh;
}
</style>
