package com.susu.oss.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import com.susu.oss.common.base.BaseDTO;

/**
 * @author fxbsujay@gmail.com
 * 上传文件表
 */
@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel("上传文件表")
public class FileDTO extends BaseDTO implements Serializable{
  
  	private static final long serialVersionUID = 1L;

	@ApiModelProperty("文件名")
   	private String name;

	@ApiModelProperty("文件链接")
   	private String url;

	@ApiModelProperty("文件保存地址")
   	private String path;

	@ApiModelProperty("是否公开 0 表示否 1 表示是")
   	private String isPublic;
	  
}