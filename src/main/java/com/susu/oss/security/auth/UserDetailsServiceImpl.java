package com.susu.oss.security.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.susu.oss.dao.UserDao;
import com.susu.oss.entity.UserEntity;
import com.susu.oss.exception.OssException;
import com.susu.oss.security.entity.SecurityUser;
import com.susu.oss.security.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  自定义自定义userDetailsService - 认证用户详情
 */
@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (StringUtils.isEmpty(username)){
            throw new OssException("用户名不存在");
        }
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        UserEntity sysUserEntity = userDao.selectOne(wrapper);

        // 判断用户是否存在
        if (null == sysUserEntity ){
            throw new OssException("用户名不存在！");
        }
        // 查询权限
        List<String> list = new ArrayList<>();

        User curUser = new User();
        // 复制
        BeanUtils.copyProperties(sysUserEntity,curUser);
        curUser.setUsername(sysUserEntity.getUsername());

        SecurityUser securityUser = new SecurityUser(curUser);
        securityUser.setPermissionValueList(list);
        return securityUser;
    }
}
