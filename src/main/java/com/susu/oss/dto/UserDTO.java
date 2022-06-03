package com.susu.oss.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import com.susu.oss.common.base.BaseDTO;
import java.util.Date;

/**
 * @author fxbsujay@gmail.com
 * 用户表
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserDTO extends BaseDTO implements Serializable{
  
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