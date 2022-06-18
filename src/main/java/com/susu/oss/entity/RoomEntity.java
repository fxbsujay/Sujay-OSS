package com.susu.oss.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import com.susu.oss.common.base.BaseEntity;
import java.util.Date;

/**
 * 用户空间
 */
@Data
@TableName("room")
@EqualsAndHashCode(callSuper=false)
public class RoomEntity extends BaseEntity implements Serializable{
  
  private static final long serialVersionUID = 1L;
   	private Long id;
	  
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
	  
   	private Date createDate;
	  
   	private Date updateDate;
	  
}