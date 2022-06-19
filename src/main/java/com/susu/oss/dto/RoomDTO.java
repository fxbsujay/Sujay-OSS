package com.susu.oss.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import com.susu.oss.common.base.BaseDTO;
import java.util.Date;

/**
 * @author fxbsujay@gmail.com
 * 用户空间
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RoomDTO extends BaseDTO implements Serializable{
  
  	private static final long serialVersionUID = 1L;
	  
	/**
	* 名称
	*/
   	private String name;
	  
	/**
	* 服务器id
	*/
   	private Long serverId;
	  
	/**
	* 访问权限 0 私有 1 公开
	*/
   	private String access;
	  
}