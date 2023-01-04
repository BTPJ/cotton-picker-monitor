<template>
  <div class="dashboard-editor-container">
    <panel-group />
  </div>
</template>

<script>
import PanelGroup from './components/PanelGroup'

export default {
  name: 'DashboardAdmin',
  components: {
    PanelGroup
  },
  methods: {}
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  min-height: 90vh;
  background-color: rgb(242, 245, 240);

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width: 1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
</style>
