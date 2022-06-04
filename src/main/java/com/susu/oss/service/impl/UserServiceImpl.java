package com.susu.oss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.susu.oss.common.base.service.impl.CrudServiceImpl;
import com.susu.oss.dao.UserDao;
import com.susu.oss.dto.UserDTO;
import com.susu.oss.entity.UserEntity;
import com.susu.oss.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@Service
public class UserServiceImpl extends CrudServiceImpl<UserDao, UserEntity, UserDTO> implements UserService {

    @Override
    public QueryWrapper<UserEntity> getWrapper(Map<String, Object> params) {
        return null;
    }
}
