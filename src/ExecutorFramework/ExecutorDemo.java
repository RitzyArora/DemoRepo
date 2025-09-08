package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public void executorDemoUsage()throws InterruptedException{
        ExecutorService executor= Executors.newFixedThreadPool(5);


        for(int i=0;i<10;i++)
        {
            int taskId=i;
            executor.submit(()->{
                System.out.println("Task "+taskId+" running in "+Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
