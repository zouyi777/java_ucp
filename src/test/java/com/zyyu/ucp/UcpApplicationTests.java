package com.zyyu.ucp;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.enums.GenderEnum;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.po.WorksPo;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.service.WorksService;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class UcpApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    WorksService worksService;

    @Test
    public void contextLoads() {
        System.out.println("单元测试开始");
        testAddWorks();
        System.out.println("单元测试结束");
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
            userPO.setNickName("易哥i");
            userPO.setIdNumber("513002199105122554");
            userPO.setRealName("邹易");
            userPO.setMobilePhone("18215626820");
            userPO.setEmail("18215626820@163.com");
            userService.add(userPO);
        }
    }

    private void testGetByPage(){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(3);
        pageInfo = userService.getAllByPage(pageInfo);
        System.out.println(pageInfo);
    }

    void testAddWorks(){
        String[] contentArr={"我是檐上三寸雪，你是人间惊鸿客","城南小陌又逢春，只见梅花不见人","本是青灯不归客，却因浊酒恋红尘"};

        for(int i=0;i<contentArr.length;i++){
            WorksPo worksPo =new WorksPo();
            worksPo.setUserId(userService.getAll().get(0).getId());
            worksPo.setContent(contentArr[i]);
            worksService.add(worksPo);
        }
    }

}
