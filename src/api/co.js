import request from '@/utils/request'

/**
 * 数据历史记录
 * @returns {*}
 */
export function getCoHisData(params) {
  return request({
    url: '/coGasInform/list',
    method: 'get',
    params
  })
}

