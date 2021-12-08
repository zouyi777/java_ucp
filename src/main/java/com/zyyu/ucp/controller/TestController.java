package com.zyyu.ucp.controller;


import com.zyyu.ucp.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private AccountService accountService;


    @RequestMapping("/transfer")
    public String test() {
        try {
            // andy 给lucy转账50元
            accountService.transfer(1, 2, 50);
            return "transfer success";
        } catch (Exception e) {
            logger.error("",e);
            return "transfer fail";
        }
    }
}
