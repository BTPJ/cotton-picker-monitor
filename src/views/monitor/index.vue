<template>
  <div class="page" @click="onClick">
    <vue-ali-player-v2
      ref="VueAliPlayerV2"
      :source="source"
      :options="options"
      @play="onPlay"
      @pause="onPause"
    />
    <i v-if="showPauseIcon" class="el-icon-caret-right" />
  </div>
</template>

<script>
import VueAliPlayerV2 from 'vue-aliplayer-v2'

export default {
  name: 'Monitor',
  components: { VueAliPlayerV2 },

  data() {
    return {
      options: {
        isLive: true, // 切换为直播流的时候必填
        format: 'm3u8' // 切换为直播流的时候必填
      },
      source: 'http://219.151.31.38/liveplay-kk.rtxapp.com/live/program/live/hnwshd/4000000/mnf.m3u8',
      showPauseIcon: false
    }
  },

  methods: {
    onClick() {
      const player = this.$refs.VueAliPlayerV2
      console.log(player.getStatus())
      switch (player.getStatus()) {
        case 'playing': // 播放状态
          player.pause()
          break

        case 'pause': // 暂停状态
          player.play()
          break
      }
    },

    onPlay() {
      this.showPauseIcon = false
    },

    onPause() {
      this.showPauseIcon = true
    }
  }
}
</script>

<style lang="scss" scoped>
.page {
  position: relative;

  .el-icon-caret-right {
    font-size: 100px;
    background: #fff;
    border-radius: 50%;
    position: absolute;
    top: 50%;
    left: 50%;
  }
}

.prism-player {
  height: 90vh !important;
}
</style>
