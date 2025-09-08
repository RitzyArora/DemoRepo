package MultiThreadingBasicsAndAdvanced;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.*;


public class CustomThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final WorkerThread[] workers;
    private volatile boolean isStopped = false;

    public CustomThreadPool(int numOfThreads,int maxTasks) {
        this.taskQueue = new ArrayBlockingQueue<>(maxTasks);
        this.workers = new WorkerThread[numOfThreads];

        for(int i=0;i<numOfThreads;i++){
            workers[i]=new WorkerThread("Worker-"+i);
            workers[i].start();
        }
    }


    public void submit(Runnable task) throws InterruptedException{
        if(!isStopped)
        {
            taskQueue.put(task);
        }
        else
        {
            throw new IllegalStateException("Thread pool is stopped");
        }
    }

    public void shutdown()
    {
        isStopped=true;
        for(WorkerThread worker:workers)
        {
            worker.interrupt();
        }
    }


    private class WorkerThread extends Thread {
        WorkerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while(!isStopped||!taskQueue.isEmpty())
            {
                try
                {
                    Runnable task=taskQueue.poll(100,TimeUnit.MILLISECONDS);
                    if(task!=null)
                    {
                        System.out.println(getName()+" executing the task");
                        task.run();
                    }
                }catch(InterruptedException e){}
            }
        }
    }

}