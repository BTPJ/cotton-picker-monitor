import request from '@/utils/request'

/**
 * 数据列表
 * @returns {*}
 */
export function getGpsList(params) {
  return request({
    url: '/gpsInform/list',
    method: 'get',
    params
  })
}

