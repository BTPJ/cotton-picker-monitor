import request from '@/utils/request'

/**
 * 数据历史记录
 * @returns {*}
 */
export function getWaterHisData(params) {
  return request({
    url: '/waterLevelInform/list',
    method: 'get',
    params
  })
}

