package com.susu.oss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.susu.oss.common.base.service.impl.CrudServiceImpl;
import com.susu.oss.dao.FileDao;
import com.susu.oss.dto.FileDTO;
import com.susu.oss.entity.FileEntity;
import com.susu.oss.service.FileService;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@Service
public class FileServiceImpl extends CrudServiceImpl<FileDao, FileEntity, FileDTO> implements FileService {

    @Override
    public QueryWrapper<FileEntity> getWrapper(Map<String, Object> params) {
        return null;
    }
}
