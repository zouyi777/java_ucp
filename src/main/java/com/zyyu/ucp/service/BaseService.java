package com.zyyu.ucp.service;

import com.zyyu.ucp.common.PageInfo;

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
}
