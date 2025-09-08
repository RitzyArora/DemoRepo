package MultiThreadingBasicsAndAdvanced;

import java.util.concurrent.locks.ReentrantLock;

public class FairUnfairDemo {

    private final ReentrantLock reentrantLock;

    public FairUnfairDemo(boolean fair)
    {
        reentrantLock=new ReentrantLock(fair);
    }

    public void printMessage()
    {
        for (int i=0;i<5;i++)
        {
            reentrantLock.lock();
            try
            {
                System.out.println(Thread.currentThread().getName()+" acquired lock (fair = "+reentrantLock.isFair()+")");
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
            finally
            {
                reentrantLock.unlock();
            }
        }
    }
}
