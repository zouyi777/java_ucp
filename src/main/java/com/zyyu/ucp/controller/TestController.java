package com.zyyu.ucp.controller;


import com.zyyu.ucp.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    /**
     * 测试普通变量是否支持事务回滚
     * 经过测试，Transactional无法控制普通变量实现回滚
     * @return
     */
    @RequestMapping("/transfer_inner")
    public String transfer_inner() {
        try {
            // andy 给lucy转账50元
            accountService.transferVar();
            return "success";
        } catch (Exception e) {
            logger.error("",e);
            return "fail";
        }
    }

    /**
     * 获取transfer_inner执行后普通变量的值
     * @return
     */
    @RequestMapping("/getTransferedVar")
    public String getTransferedVar() {
        return accountService.getTransferedVar();
    }

}
