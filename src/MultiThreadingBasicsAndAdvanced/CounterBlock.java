package MultiThreadingBasicsAndAdvanced;
//Synchronized block
//public class CounterBlock {
//    private int count=0;
//    public void increment(){
//      synchronized (this){
//          count++;
//        }

//    }
//    public int getCount(){
//        return count;
//    }
//}
public class CounterBlock {
    private int count=0;
    public  synchronized void increment(){
            count++;
    }
    public int getCount(){
        return count;
    }
}
