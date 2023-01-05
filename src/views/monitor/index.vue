<template>
  <div id="container" />
</template>

<script type="text/javascript">
window._AMapSecurityConfig = {
  securityJsCode: '7bb5ea4549807b46f5f4daca1996a086'
}
</script>
<script src="https://webapi.amap.com/loader.js"></script>

<script>
export default {
  name: 'Monitor',

  data() {
    return {}
  },

  created() {
    AMapLoader.load({
      "key": "5547555554d9352c6d8942b63efa0233",              // 申请好的Web端开发者Key，首次调用 load 时必填
      "version": "2.0",   // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
      "plugins": [],           // 需要使用的的插件列表，如比例尺'AMap.Scale'等
      "AMapUI": {             // 是否加载 AMapUI，缺省不加载
        "version": '1.1',   // AMapUI 版本
        "plugins": ['overlay/SimpleMarker'],       // 需要加载的 AMapUI ui插件
      },
      "Loca": {                // 是否加载 Loca， 缺省不加载
        "version": '2.0'  // Loca 版本
      },
    }).then((AMap) => {
      let map = new AMap.Map('container');
      // map.addControl(new AMap.Scale());
    }).catch((e) => {
      console.error(e);  //加载错误提示
    });
  },

  methods: {}
}
</script>

<style lang="scss" scoped>
#container {
  width: 300px;
  height: 180px;
}
</style>
