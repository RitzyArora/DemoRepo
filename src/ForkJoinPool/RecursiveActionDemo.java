package ForkJoinPool;

import java.util.concurrent.RecursiveAction;

public class RecursiveActionDemo extends RecursiveAction {
    private final int[] arr;
    private final int start,end;
    private static final int Threshhold=5;

    public RecursiveActionDemo(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    protected void compute() {
        int length=end-start;
        if(length<=Threshhold)
        {

            for(int i=start;i<end;i++)
                System.out.println("Value ="+arr[i]+" printed by "+Thread.currentThread().getName());
        }
        else
        {
            int mid=start+length/2;
            RecursiveActionDemo left=new RecursiveActionDemo(arr,start,mid);
            RecursiveActionDemo right=new RecursiveActionDemo(arr,mid,end);
            invokeAll(left,right);


        }
    }
}
