package MultiThreadingBasicsAndAdvanced;

public class DaemonDemo {
    public void daemonThreadUsage(){
        //daemon Thread
        Thread daemon=new Thread(()->{
            for(int i=1;i<=10;i++)
            {
                System.out.println("Daemon thread working "+i);

                try{
                    Thread.sleep(2000);
                }
                catch(InterruptedException e)
                {
                    System.out.println(e);
                }
            }
            System.out.println("Daemon finished....");
        });
        //normal thread
        Thread normal=new Thread(()->{
            for(int i=1;i<=10;i++)
            {
                System.out.println("Normal thread working "+i);
                try{
                    Thread.sleep(2000);
                }
                catch(InterruptedException e)
                {
                    System.out.println(e);
                }
            }
            System.out.println("Normal Thread working is finished");
        });


        daemon.setDaemon(true);
        daemon.start();
        normal.start();


        try{
            normal.join();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
        System.out.println("Main thread done JVM will now exit");

    }
}
