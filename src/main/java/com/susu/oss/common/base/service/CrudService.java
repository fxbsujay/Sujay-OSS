package com.susu.oss.common.base.service;

import com.susu.oss.common.PageData;
import java.util.List;
import java.util.Map;

/**
 *  CRUD基础服务接口
 */
public interface CrudService<T, D> extends BaseService<T> {

    PageData<D> page(Map<String, Object> params);

    List<D> list(Map<String, Object> params);

    D get(Long id);

    Boolean save(D dto);

    Boolean update(D dto);

    Integer delete(Long[] ids);

}
