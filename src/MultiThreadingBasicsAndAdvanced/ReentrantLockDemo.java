package MultiThreadingBasicsAndAdvanced;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private int count=0;
    private final Lock reentrantLock=new ReentrantLock();

    public void increment(){
        reentrantLock.lock();//acquiring the lock

        try{
            count++;
            System.out.println(Thread.currentThread().getName()+" increments the count value");
        }
        finally
        {
            reentrantLock.unlock();
        }
    }

    public int getCount(){
        return count;
    }
}
