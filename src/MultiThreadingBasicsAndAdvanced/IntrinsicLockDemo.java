package MultiThreadingBasicsAndAdvanced;

public class IntrinsicLockDemo {
    private final Object lock=new Object();
    public void intrinsicLockUsage()
    {
        synchronized (lock)
        {
            System.out.println(Thread.currentThread().getName()+" entered ");
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName()+" Leaving... ");
        }
    }
}
