package com.susu.oss.common.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.susu.oss.common.PageData;
import com.susu.oss.common.base.BaseDTO;
import com.susu.oss.common.base.BaseEntity;
import com.susu.oss.common.base.service.CrudService;
import com.susu.oss.common.utils.ConvertUtils;
import org.springframework.beans.BeanUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *  CRUD基础服务类
 *
 * @author Mark sunlightcs@gmail.com
 */
public abstract class CrudServiceImpl<M extends BaseMapper<T>, T extends BaseEntity, D extends BaseDTO> extends BaseServiceImpl<M, T> implements CrudService<T, D> {

    protected Class<D> currentDtoClass() {
        return (Class<D>) ReflectionKit.getSuperClassGenericType(getClass(),getClass().getSuperclass(), 2);
    }

    @Override
    public PageData<D> page(Map<String, Object> params) {
        IPage<T> page = baseDao.selectPage(
            getPage(params),
            getWrapper(params)
        );

        return getPageData(page, currentDtoClass());
    }

    @Override
    public List<D> list(Map<String, Object> params) {
        List<T> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, currentDtoClass());
    }

    public abstract QueryWrapper<T> getWrapper(Map<String, Object> params);

    @Override
    public D get(Long id) {
        T entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, currentDtoClass());
    }

    @Override
    public Boolean save(D dto) {
        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        boolean insert = insert(entity);

        //copy主键值到dto
        BeanUtils.copyProperties(entity, dto);
        return insert;
    }

    @Override
    public Boolean update(D dto) {
        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        return updateById(entity);
    }

    @Override
    public Integer delete(Long[] ids) {
        return baseDao.deleteBatchIds(Arrays.asList(ids));
    }
}
