package com.btpj.monitor.entity.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "User对象", description = "")
public class UserResp implements Serializable {
    private Long id;
    private String name;
    private String roles;
}
