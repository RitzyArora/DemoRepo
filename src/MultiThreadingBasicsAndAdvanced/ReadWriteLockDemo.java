package MultiThreadingBasicsAndAdvanced;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    private int value=0;
    private final ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    private final Lock readLock=readWriteLock.readLock();
    private final Lock writeLock=readWriteLock.writeLock();

    public int readValue(String readerName){
        readLock.lock();
        try {
            System.out.println(readerName+" reading value "+value);
            try{Thread.sleep(200);} catch(InterruptedException e){}
            return value;
        }
        finally {
            readLock.unlock();
        }
    }
    public void writeValue(String writerName,int newValue){
        writeLock.lock();
        try {
            System.out.println(writerName+" writing value "+newValue);
            try{Thread.sleep(200);} catch(InterruptedException e){}
            value=newValue;
            System.out.println(writerName+" finished writing "+newValue);
        }
        finally {
            writeLock.unlock();
        }
    }
}
