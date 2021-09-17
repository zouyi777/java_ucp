package com.zyyu.ucp;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.enums.GenderEnum;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class UcpApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
//        testLogin();
//        testGetByPage();
        Long id =UniqueKeyUtil.getUniqueKey();
        System.out.println(id);
    }

    private void testLogin(){
//        UserPo userPO = userService.loginIn("zy1","123456");
//        System.out.println(userPO.toString());
    }

    private void testAddUser(){
        for(int i=0;i<100;i++){
            UserPo userPO = new UserPo();
            if(i ==0){
                userPO.setUserName("zy");
            }else {
                userPO.setUserName("zy"+i);
            }
            userPO.setPassword("123456");
            if(i % 2 ==0){
                userPO.setGender(GenderEnum.MAN);
            }else{
                userPO.setGender(GenderEnum.FEMALE);
            }
            userService.add(userPO);
        }
    }

    private void testGetByPage(){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(3);
        pageInfo = userService.getAllByPage(pageInfo);
        System.out.println(pageInfo);
    }

}
