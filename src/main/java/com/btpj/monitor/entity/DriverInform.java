package com.btpj.monitor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "DriverInform对象", description = "")
public class DriverInform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "iDeviceId", type = IdType.AUTO)
    private Integer iDeviceId;

    private String sDriverName;

    private String sDriverPhone;

    private Integer iEngineId;

    private String sFacturers;
}
