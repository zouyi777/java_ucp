package com.zyyu.ucp.mapper;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.po.BasePo;
import java.util.List;

/**
 * 基础 Mapper
 * @param <T>
 */
public interface BaseMapper<T extends BasePo> {

    int add(T t);

    int delete(T t);

    int update(T t);

    T getById(Long id);

    List<T> getAll();

    List<T> getAllByPage(PageInfo pageInfo);

    Integer getTotalCount();

}
