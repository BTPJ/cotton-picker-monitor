<template>
  <div id="container" />
</template>

<script>
import AMapLoader from '@amap/amap-jsapi-loader'

export default {
  name: 'Monitor',

  data() {
    return {
      marker: {},
      lineArr: [[116.478935, 39.997761], [116.478939, 39.997825], [116.478912, 39.998549], [116.478912, 39.998549], [116.478998, 39.998555], [116.478998, 39.998555], [116.479282, 39.99856], [116.479658, 39.998528], [116.480151, 39.998453], [116.480784, 39.998302], [116.480784, 39.998302], [116.481149, 39.998184], [116.481573, 39.997997], [116.481863, 39.997846], [116.482072, 39.997718], [116.482362, 39.997718], [116.483633, 39.998935], [116.48367, 39.998968], [116.484648, 39.999861]]
    }
  },

  created() {
    this.setupAmap()
  },

  methods: {
    setupAmap() {
      AMapLoader.load({
        'key': '5547555554d9352c6d8942b63efa0233', // 申请好的Web端开发者Key，首次调用 load 时必填
        'version': '2.0', // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
        'plugins': ['AMap.Scale', 'AMap.ToolBar'] // 需要使用的的插件列表，如比例尺'AMap.Scale'等
      }).then((AMap) => {
        // JSAPI2.0 使用覆盖物动画必须先加载动画插件
        AMap.plugin('AMap.MoveAnimation', () => {
          const map = new AMap.Map('container', {
            zoom: 12
          })
          map.addControl(new AMap.Scale())
          map.addControl(new AMap.ToolBar({
            position: {
              bottom: '70px',
              left: '30px'
            }
          }))

          this.marker = new AMap.Marker({
            map: map,
            position: [116.484648, 39.999861],
            icon: 'https://a.amap.com/jsapi_demos/static/demo-center-v2/car.png',
            offset: new AMap.Pixel(-13, -26)
          })

          this.marker.on('click', () => this.startAnimation())

          // 绘制轨迹
          new AMap.Polyline({
            map: map,
            path: this.lineArr,
            showDir: true,
            strokeColor: '#28F', // 线颜色
            // strokeOpacity: 1,     //线透明度
            strokeWeight: 6 // 线宽
            // strokeStyle: "solid"  //线样式
          })

          const passedPolyline = new AMap.Polyline({
            map: map,
            strokeColor: '#AF5', // 线颜色
            strokeWeight: 6 // 线宽
          })

          this.marker.on('moving', function(e) {
            passedPolyline.setPath(e.passedPath)
            map.setCenter(e.target.getPosition(), true)
          })
          map.setFitView()
        })
      }).catch((e) => {
        console.error(e) // 加载错误提示
      })
    },

    startAnimation() {
      this.marker.moveAlong(this.lineArr, {
        // 每一段的时长
        duration: 200, // 可根据实际采集时间间隔设置
        // JSAPI2.0 是否延道路自动设置角度在 moveAlong 里设置
        autoRotation: true
      })
    }
  }
}
</script>

<style lang="scss" scoped>
#container {
  width: 100vw;
  height: 90vh;
}
</style>
