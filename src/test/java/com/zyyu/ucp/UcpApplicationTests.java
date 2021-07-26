package com.zyyu.ucp;

import com.zyyu.ucp.enums.GenderEnum;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UcpApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        testLogin();
//        testAddUser();
    }

    private void testLogin(){
        UserPo userPO = userService.loginIn("zy1","123456");
        System.out.println(userPO.toString());
    }

    private void testAddUser(){
        UserPo userPO = new UserPo();
        userPO.setUserName("zy1");
        userPO.setPassword("123456");
        userPO.setGender(GenderEnum.FEMALE);
        userService.addUser(userPO);
    }

}
