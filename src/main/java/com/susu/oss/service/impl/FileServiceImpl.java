package com.susu.oss.service.impl;

import com.susu.oss.common.base.BaseServiceImpl;
import com.susu.oss.dao.FileDao;
import com.susu.oss.dto.FileDTO;
import com.susu.oss.entity.FileEntity;
import com.susu.oss.service.FileService;
import org.springframework.stereotype.Service;

/**
 * @author fxbsujay@gmail.com
 */
@Service
public class FileServiceImpl extends BaseServiceImpl<FileDao, FileEntity, FileDTO> implements FileService {

}
