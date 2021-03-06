package com.susu.oss.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import com.susu.oss.common.base.BaseDTO;

/**
 * @author fxbsujay@gmail.com
 * 上传记录表
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UploadDTO extends BaseDTO implements Serializable{
  
  	private static final long serialVersionUID = 1L;

	/**
	* 上传ip
	*/
   	private String ip;
	  
	/**
	* 类型 0 图片
	*/
   	private String type;
	  
	/**
	* 文件大小
	*/
   	private Float size;
	  
	/**
	* 文件id
	*/
   	private Long fileId;
	  
}