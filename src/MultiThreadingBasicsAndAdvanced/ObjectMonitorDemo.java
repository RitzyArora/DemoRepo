package MultiThreadingBasicsAndAdvanced;

public class ObjectMonitorDemo {

    private final Object lock=new Object();
    private boolean ready=false;
    public void waiter(){
        synchronized (lock){
            while(!ready){
                try
                {
                    System.out.println(Thread.currentThread().getName()+" waiting");
                    lock.wait();
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName()+" resumed");
        }
    }
    public void notifier(){
        synchronized (lock)
        {
            ready=true;
            System.out.println(Thread.currentThread().getName()+" Notifying..");
            lock.notifyAll();
        }
    }
}
