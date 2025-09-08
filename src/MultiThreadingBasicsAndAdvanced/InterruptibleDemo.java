package MultiThreadingBasicsAndAdvanced;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleDemo {
    public void interruptibleUsage() throws InterruptedException{
        System.out.println("lockinterruptibly demo");
        ReentrantLock reentrantLock=new ReentrantLock();
        Thread holder=new Thread(()->{
            reentrantLock.lock();
            try{
                System.out.println("Holder acquired lock and doing the work");
                Thread.sleep(3000);
                System.out.println("Holder work is done");
            }
            catch (InterruptedException e){}
            finally {
                reentrantLock.unlock();
                System.out.println("Lock is released by holder");
            }
        });

        Thread waiter=new Thread(()->{

            try{
                System.out.println("Waiter calling lockInterruptibly() and will block...");
                reentrantLock.lockInterruptibly();
                try{
                    System.out.println("Waiter unexpectedly acquired the lock");
                }
                finally {
                    reentrantLock.unlock();
                }
            }
            catch (InterruptedException e){
                System.out.println("Waiter interrupted while waiting");
            }

        });

holder.start();
Thread.sleep(100);
waiter.start();
Thread.sleep(500);
        System.out.println("Main interrupting waiter");
        waiter.interrupt();

        holder.join();
        waiter.join();


    }
}
