package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.mapper.AccountMapper;
import com.zyyu.ucp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    @Transactional
    public void transfer(int outter, int inner, Integer money) {
        accountMapper.moveOut(outter, money); //转出
        int i = 1/0;  // 抛出异常
//        accountMapper.moveIn(inner, money); //转入
        accountMapper.moveOut(outter, money); //转出
    }
}
