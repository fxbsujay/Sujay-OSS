package com.susu.oss.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import com.susu.oss.common.base.BaseEntity;
import java.util.Date;

/**
 * 用户空间关联表
 */
@Data
@TableName("user_room")
@EqualsAndHashCode(callSuper=false)
public class UserRoomEntity extends BaseEntity implements Serializable{
  
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