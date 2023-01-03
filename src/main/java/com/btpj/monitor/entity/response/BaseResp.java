package com.btpj.monitor.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("通用封装普通对象")
public class BaseResp<T> {

    /**
     * 请求状态码（0：请求成功、1：请求失败、2：用户/Token过期、3：权限不足）
     */
    @ApiModelProperty("请求状态码（0：请求成功、1：请求失败、2：用户/Token过期、3：权限不足")
    private int status;

    /**
     * 请求返回信息
     */
    @ApiModelProperty("请求返回信息")
    private String msg;

    /**
     * 请求返回数据
     */
    @ApiModelProperty("请求返回数据")
    private T data;

    /**
     * 请求成功
     *
     * @param data 要返回的数据
     * @param msg  请求成功返回的消息
     * @return RespEntity
     */
    public static <T> BaseResp<T> success(T data, String msg) {
        BaseResp<T> BaseResp = new BaseResp<>();
        BaseResp.status = 0;
        BaseResp.msg = msg;
        BaseResp.data = data;
        return BaseResp;
    }

    /**
     * 请求成功
     *
     * @param data 要返回的数据
     * @return RespEntity
     */
    public static <T> BaseResp<T> success(T data) {
        return BaseResp.success(data, "请求成功");
    }

    /**
     * 请求成功
     *
     * @param msg 请求成功返回的消息
     * @return RespEntity
     */
    public static BaseResp<Void> success(String msg) {
        return BaseResp.success(null, msg);
    }

    /**
     * 请求失败
     *
     * @param msg 请求失败返回的消息
     * @return RespEntity
     */
    public static <T> BaseResp<T> error(String msg) {
        BaseResp<T> BaseResp = new BaseResp<>();
        BaseResp.status = 1;
        BaseResp.msg = msg;
        return BaseResp;
    }
}
