package com.susu.oss.service.impl;

import com.susu.oss.common.base.BaseServiceImpl;
import com.susu.oss.dao.UserDao;
import com.susu.oss.dto.UserDTO;
import com.susu.oss.entity.UserEntity;
import com.susu.oss.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author fxbsujay@gmail.com
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity, UserDTO> implements UserService {

}
