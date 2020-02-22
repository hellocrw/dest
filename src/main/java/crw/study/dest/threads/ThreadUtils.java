package crw.study.dest.threads;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/22 0022
 * @Time 3:08
 */
@Component
public class CountDownLatchTest {
    
    static CountDownLatch downLatch = new CountDownLatch(2);

    public void invoke() throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                downLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                Thread.sleep(1000);
                    System.out.println("2");
                    downLatch.countDown();
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        try {
            downLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("3");
    }
}
