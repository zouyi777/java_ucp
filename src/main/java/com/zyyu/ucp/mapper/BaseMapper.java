package com.zyyu.ucp.mapper;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.po.BasePo;
import com.zyyu.ucp.model.vo.BaseVo;
import com.zyyu.ucp.model.vo.SearchConditionBaseVo;

import java.util.List;

/**
 * 基础 Mapper
 * @param <T>
 */
public interface BaseMapper<T extends BasePo,E extends BaseVo> {

    int add(T t);

    int delete(T t);

    int update(T t);

    T getById(Long id);

    List<T> getAll();

    List<T> getAllByPage(PageInfo pageInfo);

    Integer getTotalCount();

    List searchByCondition(SearchConditionBaseVo searchConditionVo);

    Integer searchByConditionCount(SearchConditionBaseVo searchConditionVo);

}
