package MultiThreadingBasicsAndAdvanced;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBuffer {

    private final Queue<Integer> queue=new LinkedList<>();
    private final int capacity=5;

    private final ReentrantLock reentrantLock=new ReentrantLock();
    private final Condition notFull=reentrantLock.newCondition();
    private final Condition notEmpty=reentrantLock.newCondition();

    public void produce(int value)throws InterruptedException{
        reentrantLock.lock();
        try
        {
            while (queue.size()==capacity)
            {
                System.out.println(Thread.currentThread().getName()+"waiting (buffer full)");
                notFull.await();
            }
            queue.add(value);
            System.out.println(Thread.currentThread().getName()+" produced "+value);
            notEmpty.signal();
        }
        finally{
            reentrantLock.unlock();
        }
    }

    public int consume()throws InterruptedException{
        reentrantLock.lock();
        try
        {
            while (queue.isEmpty())
            {
                System.out.println(Thread.currentThread().getName()+"waiting (buffer empty)");
                notEmpty.await();
            }
            int value=queue.poll();
            System.out.println(Thread.currentThread().getName()+" consumed "+value);
            notFull.signal();
            return value;
        }
        finally{
            reentrantLock.unlock();
        }
    }
}
