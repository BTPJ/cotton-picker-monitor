<template>
  <el-row :gutter="12">
    <el-col :span="16" class="left">
      <el-card
        v-for="(item,index) in list"
        :key="index"
        class="item"
        shadow="hover"
        :body-style="{display: 'flex',alignItems:'center'}"
        @click.native="navToIndex(index)"
      >
        <img :src="item.icon" alt="">
        <span>{{ item.name }}</span>
      </el-card>
    </el-col>
    <el-col :span="8" class="right">
      <img src="../../assets/ic_tlmdx.png" alt="">
    </el-col>
  </el-row>
</template>

<script>

export default {
  name: 'Equipment',

  data() {
    return {
      list: [
        { name: '设备一', icon: require('../../assets/ic_equipment.png') },
        { name: '设备二', icon: require('../../assets/ic_equipment.png') },
        { name: '设备三', icon: require('../../assets/ic_equipment.png') },
        { name: '设备四', icon: require('../../assets/ic_equipment.png') },
        { name: '设备五', icon: require('../../assets/ic_equipment.png') },
        { name: '设备六', icon: require('../../assets/ic_equipment.png') },
        { name: '设备七', icon: require('../../assets/ic_equipment.png') },
        { name: '设备八', icon: require('../../assets/ic_equipment.png') },
        { name: '设备九', icon: require('../../assets/ic_equipment.png') },
        { name: '设备十', icon: require('../../assets/ic_equipment.png') }
      ]
    }
  },

  methods: {
    navToIndex(index) {
      if (index === 0) {
        this.$router.push('/dashboard')
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.left {
  .item {
    display: flex;
    align-items: center;
    height: 80px;
    margin: 14px 20px;
    padding: 20px;

    span {
      margin-left: 20px;
    }
  }
}

.right {
  margin: 100px 0;
  display: flex;
  justify-content: center;
  align-items: center;

  img {
    width: 400px;
    height: 400px;
  }
}

</style>
