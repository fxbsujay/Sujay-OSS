package com.susu.oss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.susu.oss.common.base.service.impl.CrudServiceImpl;
import com.susu.oss.dao.UploadDao;
import com.susu.oss.dto.UploadDTO;
import com.susu.oss.entity.UploadEntity;
import com.susu.oss.service.UploadService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@Service
public class UploadServiceImpl extends CrudServiceImpl<UploadDao, UploadEntity, UploadDTO> implements UploadService {

    @Override
    public QueryWrapper<UploadEntity> getWrapper(Map<String, Object> params) {
        return null;
    }
}
