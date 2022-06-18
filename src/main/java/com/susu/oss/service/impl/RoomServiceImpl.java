package com.susu.oss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.susu.oss.common.base.service.impl.CrudServiceImpl;
import com.susu.oss.dao.RoomDao;
import com.susu.oss.dto.RoomDTO;
import com.susu.oss.entity.RoomEntity;
import com.susu.oss.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@Service
public class RoomServiceImpl extends CrudServiceImpl<RoomDao, RoomEntity, RoomDTO> implements RoomService {

    @Override
    public QueryWrapper<RoomEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<RoomEntity> wrapper = new QueryWrapper<>();
        return wrapper;
    }
}
