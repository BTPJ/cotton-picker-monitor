<template>
  <div class="page">
    <div class="player1" @click="onClick1">
      <vue-ali-player-v2
        ref="VueAliPlayerV21"
        :source="source1"
        :options="options"
        @play="onPlay1"
        @pause="onPause1"
      />
      <i v-if="showPauseIcon1" class="el-icon-caret-right" />
    </div>
    <div class="player2" @click="onClick2">
      <vue-ali-player-v2
        ref="VueAliPlayerV22"
        :source="source2"
        :options="options"
        @play="onPlay2"
        @pause="onPause2"
      />
      <i v-if="showPauseIcon2" class="el-icon-caret-right" />
    </div>
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
      source1: 'http://192.168.1.16/hlsram/chn0/index.m3u8',
      source2: 'http://192.168.1.16/hlsram/chn1/index.m3u8',
      showPauseIcon1: false,
      showPauseIcon2: false
    }
  },

  methods: {
    onClick1() {
      const player = this.$refs.VueAliPlayerV21
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

    onClick2() {
      const player = this.$refs.VueAliPlayerV22
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

    onPlay1() {
      this.showPauseIcon1 = false
    },

    onPause1() {
      this.showPauseIcon1 = true
    },

    onPlay2() {
      this.showPauseIcon2 = false
    },

    onPause2() {
      this.showPauseIcon2 = true
    }
  }
}
</script>

<style lang="scss" scoped>
.page {
  display: flex;
  .player1, .player2 {
    flex: 1;
    margin-right: 10px;
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
}

.prism-player {
  height: 90vh !important;
}
</style>
