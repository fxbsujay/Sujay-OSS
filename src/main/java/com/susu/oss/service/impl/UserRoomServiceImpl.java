package com.susu.oss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.susu.oss.common.base.service.impl.CrudServiceImpl;
import com.susu.oss.dao.UserRoomDao;
import com.susu.oss.dto.UserRoomDTO;
import com.susu.oss.entity.RoomEntity;
import com.susu.oss.entity.UserRoomEntity;
import com.susu.oss.service.UserRoomService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@Service
public class UserRoomServiceImpl extends CrudServiceImpl<UserRoomDao, UserRoomEntity, UserRoomDTO> implements UserRoomService {

    @Override
    public QueryWrapper<UserRoomEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<UserRoomEntity> wrapper = new QueryWrapper<>();
        return wrapper;
    }
}
