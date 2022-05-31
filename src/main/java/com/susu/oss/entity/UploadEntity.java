package com.susu.oss.entity;

import com.susu.oss.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/**
 * @author fxbsujay@gmail.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UploadEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ip;

    private String type;

    private Float size;

    private Long fileId;
}
