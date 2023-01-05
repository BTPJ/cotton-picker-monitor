import request from '@/utils/request'

/**
 * 数据历史记录
 * @returns {*}
 */
export function getHallHisData(params) {
  return request({
    url: '/hallInform/list',
    method: 'get',
    params
  })
}

