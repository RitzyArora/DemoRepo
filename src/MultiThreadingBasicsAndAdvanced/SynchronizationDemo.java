package MultiThreadingBasicsAndAdvanced;

public class SynchronizationDemo {
    public void synchronizedBlockDemo() throws InterruptedException{
        CounterBlock counterBlock=new CounterBlock();

        Runnable task=()->{
            for(int i=0;i<1000;i++)
            {
            counterBlock.increment();
            }
        };
        Thread threadOne=new Thread(task);
        Thread threadTwo=new Thread(task);

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("Final Count is "+counterBlock.getCount());
    }

}
