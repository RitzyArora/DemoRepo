package MultiThreadingBasicsAndAdvanced;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
    public void tryLockUsage() throws InterruptedException{
        ReentrantLock reentrantLock=new ReentrantLock();
        reentrantLock.lock();//holding the lock so threadone tryLock might fail

        try {
            Thread threadOne=new Thread(()->{
               if(reentrantLock.tryLock())//non blocking attempt
               {
                   try{
                       System.out.println("Thread one got the lock quickly and doing work quickly");
                   }
                   finally {
                       reentrantLock.unlock();
                   }
               }
               else
               {
                   System.out.println("Thread one didn't get lock!!");
               }
            });
            threadOne.start();
            threadOne.join();
        }
        finally {
            reentrantLock.unlock();
        }
    }
}
