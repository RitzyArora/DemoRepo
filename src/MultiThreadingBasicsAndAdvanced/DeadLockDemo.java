package MultiThreadingBasicsAndAdvanced;

public class DeadLockDemo {
    private static final Object LOCK1= new Object();
    private static final Object LOCK2= new Object();

    public void deadLockUsage(){
        Thread threadOne=new Thread(()->{
            synchronized (LOCK1) {
                System.out.println("Thread 1 holding LOCK1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1 is waiting for LOCK2");
                synchronized (LOCK2) {
                    System.out.println("Thread 1 acquiring LOCK2");
                }
            }
        });

        Thread threadTwo=new Thread(()->{
            synchronized (LOCK2) {
                System.out.println("Thread 2 holding LOCK2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 2 is waiting for LOCK1");
                synchronized (LOCK1) {
                    System.out.println("Thread 2 acquiring LOCK1");
                }
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}
