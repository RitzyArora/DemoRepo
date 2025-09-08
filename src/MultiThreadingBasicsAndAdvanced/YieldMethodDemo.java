package MultiThreadingBasicsAndAdvanced;

public class YieldMethodDemo extends Thread{
    public void run(){
        for(int i=1;i<=10;i++)
        {
            System.out.println(getName()+" - "+i);
            Thread.yield();
        }
    }
}
