package com.btpj.monitor.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "CoGasInform对象", description = "")
public class CoGasInform implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer fCoGas;

    private String sTime;
}
