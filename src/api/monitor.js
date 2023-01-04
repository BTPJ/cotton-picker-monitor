import request from '@/utils/request'

/**
 * 实时检测数据
 * @returns {*}
 */
export function getMonitorLatestData() {
  return request({
    url: '/monitor/latest',
    method: 'get'
  })
}

