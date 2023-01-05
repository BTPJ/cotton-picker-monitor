import request from '@/utils/request'

/**
 * 设备分页列表
 * @returns {*}
 */
export function getDevicePageList(params) {
  return request({
    url: '/driverInform/page',
    method: 'get',
    params
  })
}

