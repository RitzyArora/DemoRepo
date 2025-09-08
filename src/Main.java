import ExecutorFramework.CompletableFutureTimeoutDemo;
import ExecutorFramework.ExecutorDemo;
import ExecutorFramework.PoolMetrics;
import ForkJoinPool.ForkJoinWithParallelStream;
import ForkJoinPool.*;
import MultiThreadingBasicsAndAdvanced.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Object unfairLock = new Object();

    //    static volatile boolean running=true;
//    static class Burner extends Thread{
//        long iterations=0;
//        Burner(String name,int prio){
//            super(name);
//            setPriority(prio);
//        }
//
//        @Override
//        public void run() {
//            while(running)
//            {
//                iterations++;
//            }
//        }
//    }
    public static void main(String[] args) throws Exception {
//Burner low=new Burner("low",Thread.MIN_PRIORITY);
//Burner norm=new Burner("norm",Thread.NORM_PRIORITY);
//Burner high=new Burner("high",Thread.MAX_PRIORITY);
//low.start();
//norm.start();
//high.start();
//Thread.sleep(5000);
//running=false;
//low.join();
//norm.join();
//high.join();
//
//        System.out.println("High Iterations"+high.iterations);
//        System.out.println("Norm Iterations"+norm.iterations);
//        System.out.println("Low Iterations"+low.iterations);


        //round robin algo
//        int quantum=2;
//        List<RoundRobinSchedulingDemo.RRTask> tasks=new ArrayList<>();
//        tasks.add(new RoundRobinSchedulingDemo.RRTask("First",7));
//        tasks.add(new RoundRobinSchedulingDemo.RRTask("Second",5));
//        tasks.add(new RoundRobinSchedulingDemo.RRTask("Third",9));
//
//        while(true){
//            boolean anyLeft=false;
//            for(RoundRobinSchedulingDemo.RRTask t:tasks)
//            {
//                if(t.remainingUnits>0)
//                {
//                    t.runQueue(quantum);
//                    anyLeft=true;
//                }
//            }
//            if(!anyLeft) break;
//        }
//        System.out.println("All task completed");


        //Daemon thread demo
//        DaemonDemo daemonDemo=new DaemonDemo();
//        daemonDemo.daemonThreadUsage();

        //Synchronized Block
//        SynchronizationDemo synchronizationDemo=new SynchronizationDemo();
//        synchronizationDemo.synchronizedBlockDemo();

        //intrinsic lock
//        IntrinsicLockDemo intrinsicLockDemo=new IntrinsicLockDemo();
//        Runnable task=intrinsicLockDemo::intrinsicLockUsage;
//        Thread threadOne=new Thread(task,"Thread-1");
//        Thread threadTwo=new Thread(task,"Thread-2");
//        threadOne.start();
//        threadTwo.start();


        //Object Monitor
//        ObjectMonitorDemo objectMonitorDemo=new ObjectMonitorDemo();
//        Thread waiterThreadOne=new Thread(objectMonitorDemo::waiter,"Waiter-Thread-1");
//        Thread waiterThreadTwo=new Thread(objectMonitorDemo::waiter,"Waiter-Thread-2");
//        Thread notifierThread=new Thread(objectMonitorDemo::notifier,"Notifier-Thread");
//
//        waiterThreadOne.start();
//        waiterThreadTwo.start();
//        Thread.sleep(3000);
//        notifierThread.start();

        //thread-local usage

//Runnable taskOne=()->{
//    RequestContextHolder.set(new RequestContext("User123","Ram"));
//    processRequest();
//    RequestContextHolder.clear();
//};
//
//
//        Runnable taskTwo=()->{
//            RequestContextHolder.set(new RequestContext("User124","Shyam"));
//            processRequest();
//            RequestContextHolder.clear();
//        };
//
//        new Thread(taskOne,"ThreadOne").start();
//        new Thread(taskTwo,"ThreadTwo").start();
//
//    }
//
//    private static void processRequest(){
//RequestContext requestContext=RequestContextHolder.get();
//        System.out.println(Thread.currentThread().getName()+" handling request with requestId as "+
//                requestContext.getRequestId()+" for user "+requestContext.getUser());
//    }


        //yield method demo
//        YieldMethodDemo yieldMethodDemo1=new YieldMethodDemo();
//        YieldMethodDemo yieldMethodDemo2=new YieldMethodDemo();
//        yieldMethodDemo1.start();
//        yieldMethodDemo2.start();


        //Deadlock condition
//        DeadLockDemo deadLockDemo=new DeadLockDemo();
//        deadLockDemo.deadLockUsage();


        //Livelock
//        LiveLockDemo.Resource resourceOne=new LiveLockDemo.Resource("Resource-1");
//        LiveLockDemo.Resource resourceTwo=new LiveLockDemo.Resource("Resource-2");
//
//        Thread threadOne=new Thread(()->{
//            while(true)
//            {
//                if(resourceOne.tryLock())
//                {
//                    System.out.println("Thread-1 locked "+resourceOne.getName());
//                    try{Thread.sleep(1000);} catch(InterruptedException e){}
//                    if(resourceTwo.tryLock())
//                    {
//                        System.out.println("Thread 1 locked "+resourceTwo.getName());
//                        break;
//                    }
//                    else{
//                        System.out.println("Thread 1 releasing "+resourceOne.getName());
//                        resourceOne.unlock();
//                    }
//                }
//            }
//        });
//
//        Thread threadTwo=new Thread(()->{
//            while(true)
//            {
//                if(resourceTwo.tryLock())
//                {
//                    System.out.println("Thread-2 locked "+resourceTwo.getName());
//                    try{Thread.sleep(1000);} catch(InterruptedException e){}
//                    if(resourceOne.tryLock())
//                    {
//                        System.out.println("Thread 2 locked "+resourceOne.getName());
//                        break;
//                    }
//                    else{
//                        System.out.println("Thread 2 releasing "+resourceTwo.getName());
//                        resourceTwo.unlock();
//                    }
//                }
//            }
//        });
//threadOne.start();
//threadTwo.start();


        //starvation
//        Runnable task=()->{
//            while(true)
//            {
//                synchronized(unfairLock)
//                {
//                    System.out.println(Thread.currentThread().getName()+"finally got time");
//                    try{Thread.sleep(1000);} catch(InterruptedException e){}
//                }
//            }
//        };
//
//
//        Runnable task2=()->{
//            while(true)
//            {
//                synchronized(unfairLock)
//                {
//                    System.out.println(Thread.currentThread().getName()+"Starving");
//                    break;
//                }
//            }
//        };
//
//
//        //low priority thread
//        Thread low=new Thread(task2,"LowPriorityThread");
//        low.setPriority(Thread.MIN_PRIORITY);
//
//        //High Priority thread
//        Thread high=new Thread(task,"HighPriorityThread-1");
//        low.setPriority(Thread.MAX_PRIORITY);
//
//        Thread high2=new Thread(task,"HighPriorityThread-2");
//        low.setPriority(Thread.MAX_PRIORITY);
//
//        low.start();
//        high.start();
//        high2.start();


//ReentrantLock
//        ReentrantLockDemo reentrantLockDemo=new ReentrantLockDemo();
//
//        Runnable task=()->{
//          for(int i=0;i<10;i++)
//          {
//              reentrantLockDemo.increment();
//              try
//              {
//                  Thread.sleep(1000);
//              }
//              catch(InterruptedException e){
//                  Thread.currentThread().interrupt();
//              }
//          }
//        };
//
//        Thread threadOne=new Thread(task,"ThreadOne");
//        Thread threadTwo=new Thread(task,"ThreadTwo");
//        threadOne.start();
//        threadTwo.start();
//
//        try
//        {
//            threadOne.join();
//            threadTwo.join();
//        }
//        catch(InterruptedException e){
//            Thread.currentThread().interrupt();
//        }
//        System.out.println("Total count is "+reentrantLockDemo.getCount());


        //fair unfair lock mechanism
//        System.out.println("Fair lock");
//        FairUnfairDemo fairLock=new FairUnfairDemo(true);
//        runTest(fairLock);
//        System.out.println("Unfair lock ");
//        FairUnfairDemo unFairLock=new FairUnfairDemo(false);
//        runTest(unFairLock);
//    }
//
//    private static void runTest(FairUnfairDemo demo)
//    {
//        Runnable task=demo::printMessage;
//
//        Thread threadOne=new Thread(task,"ThreadOne");
//        Thread threadTwo=new Thread(task,"ThreadTwo");
//        Thread threadThree=new Thread(task,"ThreadThree");
//
//        threadOne.start();
//        threadTwo.start();
//        threadThree.start();
//
//        try
//        {
//            threadOne.join();
//            threadTwo.join();
//            threadThree.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }


//        //Reentrant lock with condition object
//        SharedBuffer sharedBuffer=new SharedBuffer();
//
//        //producer thread
//        Runnable producerThreadTask=()->{
//          for(int i=1;i<=10;i++)
//          {
//              try{
//                  sharedBuffer.produce(i);
//                  Thread.sleep(100);
//              }
//              catch(InterruptedException e)
//              {
//                  Thread.currentThread().interrupt();
//              }
//          }
//        };
//
//        //consumer thread
//        Runnable consumerThreadTask=()->{
//            for(int i=1;i<=10;i++)
//            {
//                try{
//                    sharedBuffer.consume();
//                    Thread.sleep(150);
//                }
//                catch(InterruptedException e)
//                {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        };
//
//        Thread producer=new Thread(producerThreadTask,"Producer");
//        Thread consumer=new Thread(consumerThreadTask,"Consumer");
//        producer.start();
//        consumer.start();

//lockinterruptibly
//        InterruptibleDemo interruptibleDemo=new InterruptibleDemo();
//        interruptibleDemo.interruptibleUsage();

////tryLockDemo
//        TryLockDemo tryLockDemo=new TryLockDemo();
//        tryLockDemo.tryLockUsage();


        //ReadWriteLockDemo
//        ReadWriteLockDemo readWriteLockDemo=new ReadWriteLockDemo();
//        Thread [] threads=new Thread[5];
//        //3 readers
//        for(int i=0;i<3;i++)
//        {
//            String name="Reader-"+(i+1);
//            threads[i]=new Thread(()->{
//               for(int j=0;j<3;j++)
//               {
//                   readWriteLockDemo.readValue(name);
//               }
//            });
//        }
//
//        //2 writer
//        for(int i=0;i<2;i++)
//        {
//            String name="Writer-"+(i+1);
//            int newVal=(i+1)*10;
//            threads[3+i]=new Thread(()->{
//                readWriteLockDemo.writeValue(name,newVal);
//            });
//        }
//
//
//        for(Thread t:threads)
//        {
//            t.start();
//        }
//        for(Thread t:threads)
//        {
//            t.join();
//        }
//        System.out.println("All tasks are finished");



        //Executor simple demo
//        ExecutorDemo executorDemo=new ExecutorDemo();
//        executorDemo.executorDemoUsage();

        //Pool metrics as well how to handle rejection policies
//        PoolMetrics poolMetrics=new PoolMetrics();
//        poolMetrics.poolMetricsUsage();

//Cached thread pool
//        ExecutorService cached= Executors.newCachedThreadPool();
//        for(int i=1;i<=10;i++)
//        {
//            cached.submit(task(i,1000));
//        }
//        cached.shutdown();

//        //work-stealing pool
//        ExecutorService stealing=Executors.newWorkStealingPool();
//        for(int i=1;i<=10;i++)
//        {
//            stealing.submit(task(i,1000));
//        }
//        stealing.shutdown();
//        stealing.awaitTermination(5, TimeUnit.SECONDS);



        //ScheduledExecutorService
//        ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
//        Runnable task=()->{
//            System.out.println("task running at "+System.currentTimeMillis()/1000);
//        };
//
//        scheduler.scheduleAtFixedRate(task,1,2,TimeUnit.SECONDS);
//
//        scheduler.schedule(()->{
//            System.out.println("Shutting down...");
//            scheduler.shutdown();
//        },10,TimeUnit.SECONDS);


        //Completable Future
        //normal async pipeline
//        CompletableFutureTimeoutDemo completableFutureTimeoutDemo=new CompletableFutureTimeoutDemo();
//        completableFutureTimeoutDemo.simpleCompletableFutureUsage();



        //ForkJoinPool usage
//        ForkJoinWithParallelStream forkJoinWithParallelStream=new ForkJoinWithParallelStream();
//        forkJoinWithParallelStream.forkJoinWithParallelStreamDemo();


        //RecursiveTask
//        int []numberArray={1,2,3,4,5,6,7,8,9};
//        ForkJoinPool pool=new ForkJoinPool();
//        RecursiveTaskDemo recursiveTaskDemo = new RecursiveTaskDemo(numberArray,0,numberArray.length);
//        int result=pool.invoke(recursiveTaskDemo);
//
//        System.out.println("Sum of array ="+result);
//        pool.shutdown();

        //RecursiveAction
//        int []numberArray={1,2,3,4,5,6,7,8,9,10};
//
//        ForkJoinPool pool=new ForkJoinPool();
//        RecursiveActionDemo recursiveActionDemo = new RecursiveActionDemo(numberArray,0,numberArray.length);
//        pool.invoke(recursiveActionDemo);
//        pool.shutdown();


        //CustomThreadPool
        CustomThreadPool pool=new CustomThreadPool(3,10);

        for(int i=1;i<8;i++)
        {
            int taskId=i;
            pool.submit(()->{
                System.out.println("Task "+taskId+" started by "+Thread.currentThread().getName());

            try{Thread.sleep(1000);} catch (InterruptedException e) {

            }
            System.out.println("Task "+taskId+" finished by "+Thread.currentThread().getName());
            });
        }
        Thread.sleep(3000);
        pool.shutdown();








    }
//   public static Runnable task(int id,int sleepMs){
//        return ()->{
//            String name = Thread.currentThread().getName();
//            System.out.println("Task " + id + " running on " + name);
//            try {
//                Thread.sleep(sleepMs);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            System.out.println("Task " + id + " finished by " + name);
//        };
   // }

}