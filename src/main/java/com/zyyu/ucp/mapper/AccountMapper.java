package com.zyyu.ucp.mapper;

public interface AccountMapper {

    public void moveIn(int id, float money); // 转入

    public void moveOut(int id,float money); // 转出

}
