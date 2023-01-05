<template>
  <el-row :gutter="40" class="panel-group">
    <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
      <div class="card-panel" @click="navToHisData">
        <div class="card-panel-icon-wrapper icon-people">
          <svg-icon icon-class="dashboard" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            转速
          </div>
          <count-to
            :start-val="0"
            :end-val="latestData.hall.ihall"
            :duration="3000"
            class="card-panel-num"
          />
          <div class="card-panel-time">
            {{ latestData.hall.stime }}
          </div>
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
      <div class="card-panel" @click="navToHisData">
        <div class="card-panel-icon-wrapper icon-message">
          <svg-icon icon-class="theme" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            温度
          </div>
          <count-to
            :start-val="0"
            :end-val="latestData.temperature.ftemperature"
            :duration="3000"
            class="card-panel-num"
          />
          <div class="card-panel-time">
            {{ latestData.temperature.stime }}
          </div>
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
      <div class="card-panel" @click="navToHisData">
        <div class="card-panel-icon-wrapper icon-co">
          <svg-icon icon-class="eye-open" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            CO含量
          </div>
          <count-to :start-val="0" :end-val="latestData.co.fcoGas" :duration="3200" class="card-panel-num" />
          <div class="card-panel-time">
            {{ latestData.co.stime }}
          </div>
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
      <div class="card-panel" @click="navToHisData">
        <div class="card-panel-icon-wrapper icon-fire">
          <svg-icon icon-class="chart" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            火焰
          </div>
          <count-to :start-val="0" :end-val="latestData.fire.ifire" :duration="3600" class="card-panel-num" />
          <div class="card-panel-time">
            {{ latestData.fire.stime }}
          </div>
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
      <div class="card-panel" @click="navToHisData">
        <div class="card-panel-icon-wrapper icon-water">
          <svg-icon icon-class="example" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            水位
          </div>
          <count-to :start-val="0" :end-val="latestData.water.fwaterLevel" :duration="3600" class="card-panel-num" />
          <div class="card-panel-time">
            {{ latestData.water.stime }}
          </div>
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script>
import CountTo from 'vue-count-to'
import { getMonitorLatestData } from '@/api/monitor'

export default {
  components: {
    CountTo
  },

  data() {
    return {
      latestData: {}
    }
  },

  created() {
    this.fetchLatestData()
  },

  methods: {
    async fetchLatestData() {
      const { data } = await getMonitorLatestData()
      this.latestData = data
    },

    navToHisData() {
      this.$router.push('/hisData/index')
    }
  }
}
</script>

<style lang="scss" scoped>
.panel-group {
  margin-top: 18px;

  .card-panel-col {
    margin-bottom: 60px;
  }

  .card-panel {
    height: 200px;
    cursor: pointer;
    font-size: 12px;
    position: relative;
    display: flex;
    align-items: center;
    justify-content: space-around;
    overflow: hidden;
    color: #666;
    background: #fff;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
    border-color: rgba(0, 0, 0, .05);

    &:hover {
      .card-panel-icon-wrapper {
        color: #fff;
      }

      .icon-people {
        background: #40c9c6;
      }

      .icon-message {
        background: #36a3f7;
      }

      .icon-co {
        background: #c09b25;
      }

      .icon-fire {
        background: #e11436;
      }

      .icon-water {
        background: #447e1f;
      }
    }

    .icon-people {
      color: #40c9c6;
    }

    .icon-message {
      color: #36a3f7;
    }

    .icon-co {
      color: #c09b25;
    }

    .icon-fire {
      color: #e11436;
    }

    .icon-water {
      color: #447e1f;
    }

    .card-panel-icon-wrapper {
      float: left;
      margin: 14px;
      padding: 16px;
      transition: all 0.38s ease-out;
      border-radius: 6px;
    }

    .card-panel-icon {
      float: left;
      font-size: 100px;
    }

    .card-panel-description {
      float: right;
      font-weight: bold;
      margin: 26px 26px 26px 0;

      .card-panel-text {
        line-height: 18px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 24px;
        margin-bottom: 14px;
      }

      .card-panel-num {
        font-size: 30px;
      }

      .card-panel-time {
        margin-top: 8px;
        font-size: 14px;
      }
    }
  }
}

@media (max-width: 550px) {
  .card-panel-description {
    display: none;
  }

  .card-panel-icon-wrapper {
    float: none !important;
    width: 100%;
    height: 100%;
    margin: 0 !important;

    .svg-icon {
      display: block;
      margin: 14px auto !important;
      float: none !important;
    }
  }
}
</style>
