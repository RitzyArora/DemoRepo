package ExecutorFramework;

import java.util.concurrent.*;

public class PoolMetrics {
    public void poolMetricsUsage() throws InterruptedException {
        ThreadFactory factory = new ThreadFactory() {
            private int count = 1;

            @Override
            public synchronized Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "Worker-" + count++);
                thread.setUncaughtExceptionHandler((th, ex) -> {
                    System.out.println("Exception in " + th.getName() + ":" + ex);

                });
                return thread;
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(2, factory);

        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

        RejectedExecutionHandler rejectedExecutionHandler=(r,e)->{
            System.out.println("Task rejected :"+r);
        };

        ThreadPoolExecutor tpe=new ThreadPoolExecutor(4,5,10,TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),factory,rejectedExecutionHandler);
        //submit task
//        for (int i = 0; i < 5; i++) {
//            int taskId = i;
//            executor.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + "running");
//                if (taskId == 3) throw new RuntimeException("Exception occurred");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }

        for (int i = 0; i < 5; i++) {
            int taskId = i;
            tpe.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "running");
                if (taskId == 3) throw new RuntimeException("Exception occurred");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        Thread.sleep(1000);
        System.out.println("Pool size " + pool.getPoolSize() + " Active " + pool.getActiveCount() + " Queue " + pool.getQueue().size()
                + " Completed " + pool.getCompletedTaskCount());

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
    }

