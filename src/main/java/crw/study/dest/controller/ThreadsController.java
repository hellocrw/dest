package crw.study.dest.controller;

import crw.study.dest.threads.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/22 0022
 * @Time 2:29
 */
@RestController
public class TestController {

    @Autowired
    private ThreadUtils countDownLatchTest;

    @GetMapping("/test")
    public String Test(){
        return "测试接口";
    }

    @RequestMapping("/thread")
    public void ThreadTest() throws Exception{
//        countDownLatchTest.myCountDownLatch();
        countDownLatchTest.myCyclicBarrier();
    }
}
