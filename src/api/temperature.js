import request from '@/utils/request'

/**
 * 数据历史记录
 * @returns {*}
 */
export function getTemperatureHisData(params) {
  return request({
    url: '/temperatureInform/list',
    method: 'get',
    params
  })
}

