package com.susu.oss.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import com.susu.oss.common.base.BaseDTO;
import java.util.Date;

/**
 * @author fxbsujay@gmail.com
 * 用户空间关联表
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserRoomDTO extends BaseDTO implements Serializable{
  
  private static final long serialVersionUID = 1L;
   	private Long id;
	  
	/**
	* 用户
	*/
   	private Long userId;
	  
	/**
	* 空间id
	*/
   	private Long roomId;
	  
   	private Date createDate;
	  
   	private Date updateDate;
	  
}