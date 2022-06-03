package com.susu.oss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import com.susu.oss.common.base.BaseEntity;
import java.util.Date;

/**
 * 用户表
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserEntity extends BaseEntity implements Serializable{
  
  	private static final long serialVersionUID = 1L;

	/**
	* 用户名
	*/
   	private String username;
	  
	/**
	* 密码
	*/
   	private String password;
	  
	/**
	* 0 禁用 1启用
	*/
   	private String status;
	  
}