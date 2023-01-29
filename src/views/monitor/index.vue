<template>
  <div class="page">
    <div class="player1">
      <video ref="player1" controls preload />
    </div>
    <div class="player2">
      <video ref="player2" controls preload />
    </div>
  </div>
</template>

<script>
import Hls from 'hls.js'

export default {
  name: 'Monitor',

  data() {
    return {
      hlsPlayer1: '',
      hlsPlayer2: ''
    }
  },

  created() {
    this.$once('hook:beforeDestroy', () => this.destroyHls())
  },

  mounted() {
    this.startVideo()
  },

  methods: {
    destroyHls() {
      if (this.hlsPlayer1) {
        this.$refs.player1.pause()
        this.hlsPlayer1.destroy()
        this.hlsPlayer1 = null
      }

      if (this.hlsPlayer2) {
        this.$refs.player2.pause()
        this.hlsPlayer2.destroy()
        this.hlsPlayer2 = null
      }
    },

    startVideo() {
      if (Hls.isSupported()) {
        const player1 = this.$refs.player1
        this.hlsPlayer1 = new Hls()
        this.hlsPlayer1.loadSource('http://192.168.1.16/hlsram/chn0/index.m3u8')
        this.hlsPlayer1.attachMedia(player1)
        this.hlsPlayer1.on(Hls.Events.MANIFEST_PARSED, () => {
          console.log('视频1加载成功')
          player1.play()
        })
        this.hlsPlayer1.on(Hls.Events.ERROR, () => {
          console.error('视频1加载失败')
        })

        const player2 = this.$refs.player2
        this.hlsPlayer2 = new Hls()
        this.hlsPlayer2.loadSource('http://192.168.1.16/hlsram/chn1/index.m3u8')
        this.hlsPlayer2.attachMedia(player2)
        this.hlsPlayer2.on(Hls.Events.MANIFEST_PARSED, () => {
          console.log('视频2加载成功')
          player2.play()
        })
        this.hlsPlayer2.on(Hls.Events.ERROR, () => {
          console.error('视频2加载失败')
        })
      }
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

    video {
      width: 100%;
      height: 92vh;
      object-fit: fill;
    }
  }
}
</style>
