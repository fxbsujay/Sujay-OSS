package com.susu.oss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import com.susu.oss.common.base.BaseEntity;
import java.util.Date;

/**
 * 上传文件表
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FileEntity extends BaseEntity implements Serializable{
  
  	private static final long serialVersionUID = 1L;
  
	/**
	* 文件名
	*/
   	private String name;

	/**
	* 文件链接
	*/
   	private String url;
	  
	/**
	* 文件保存地址
	*/
   	private String path;
	  
	/**
	* 是否公开 0 表示否 1 表示是
	*/
   	private String isPublic;
	  
}