package com.zyyu.ucp.controller.admin;


import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/log")
public class LogTestController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(LogTestController.class);


    @GetMapping(value = "/test")
    public Result test(){
        logger.trace("trace");
        logger.debug("debugger");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        try {
            testLogger();
        } catch (Exception e) {
            logger.error("testLogger",e);
        }
        return success("testLog");
    }

    private void testLogger() throws Exception{
        String aa = null;
        if(aa.equals("2")){

        }
    }
}
