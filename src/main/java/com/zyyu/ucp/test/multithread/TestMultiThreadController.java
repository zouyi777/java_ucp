package com.zyyu.ucp.test.multithread;

import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 研究多线程不同步,引起数据超发的问题
 */
@RestController
@RequestMapping("/multi_thread")
public class TestMultiThreadController extends BaseController {

    // 初始化票数10
    private int ticket = 10;

    /**
     * 模拟窗口抢票
     * @return
     */
    @GetMapping(value = "/test")
    public Result test(){
        long threadNum = Thread.currentThread().getId();
        String result = null;
        if(ticket>0){
            try {
                Thread.sleep(500l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = threadNum+" window get: the num" + ticket-- +" ticket";
        }else{
            result = "ticket is over";
        }
        return success(result);
    }

}
