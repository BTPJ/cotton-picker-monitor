import request from '@/utils/request'

/**
 * 数据历史记录
 * @returns {*}
 */
export function getFireHisData(params) {
  return request({
    url: '/fireInform/list',
    method: 'get',
    params
  })
}

