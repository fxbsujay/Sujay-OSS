package com.susu.oss.common.base.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * 基础服务接口，所有Service接口都要继承
 */
public interface BaseService<T> {

    /**
     * <p>
     * 插入一条记录（选择字段，策略插入）
     * </p>
     *
     * @param entity 实体对象
     */
    boolean insert(T entity);

    /**
     * <p>
     * 根据 ID 选择修改
     * </p>
     *
     * @param entity 实体对象
     */
    boolean updateById(T entity);

    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param entity        实体对象
     * @param updateWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper}
     */
    boolean update(T entity, Wrapper<T> updateWrapper);
    /**
     * <p>
     * 根据 ID 查询
     */
    T selectById(Long id);

    /**
     * 根据 ID 删除
     */
    boolean deleteById(Long id);
}
