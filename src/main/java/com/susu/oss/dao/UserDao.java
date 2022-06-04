package com.susu.oss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.susu.oss.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fxbsujay@gmail.com
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
