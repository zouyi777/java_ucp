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

    /***测试普通变量是否支持事务回滚****/
    private int jackBlance = 300;
    private int tomBlance = 300;
    /***测试普通变量是否支持事务回滚****/


    @Override
    @Transactional
    public void transfer(int outter, int inner, Integer money) {
        accountMapper.moveOut(outter, money); //转出
        int i = 1/0;  // 抛出异常
//        accountMapper.moveIn(inner, money); //转入
        accountMapper.moveOut(outter, money); //转出
    }


    /**
     * 经过测试，Transactional无法控制普通变量实现回滚
     */
    @Override
    @Transactional
    public void transferVar() {
        jackBlance = jackBlance -50;
        int i = 1/0;
        tomBlance = tomBlance +50;

    }

    @Override
    public String getTransferedVar() {
        return "jackBlance="+jackBlance+";  tomBlance="+tomBlance;
    }

}
