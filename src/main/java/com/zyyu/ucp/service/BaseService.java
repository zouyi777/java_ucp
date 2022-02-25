package com.zyyu.ucp.service;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.vo.SearchConditionBaseVo;

import java.util.List;

/**
 * 基础Service
 * @param <T>
 */
public interface BaseService<T> {

    int add(T t);

    int delete(T t);

    int update(T t);

    T getById(Long id);

    List<T> getAll();

    Integer getTotalCount();

    PageInfo getAllByPage(PageInfo pageInfo);

    PageInfo searchByCondition(SearchConditionBaseVo searchConditionVo);

    Integer searchByConditionCount(SearchConditionBaseVo searchConditionVo);
}
