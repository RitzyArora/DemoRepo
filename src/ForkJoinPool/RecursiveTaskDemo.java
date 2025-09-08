package ForkJoinPool;

import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemo extends RecursiveTask<Integer> {
    private final int[] arr;
    private final int start,end;
    private static final int Threshhold=5;

    public RecursiveTaskDemo(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int length=end-start;
        if(length<=Threshhold)
        {
            int sum=0;
            for(int i=start;i<end;i++)
                sum=sum+arr[i];
            return sum;
        }
        else
        {
            int mid=start+length/2;
            RecursiveTaskDemo left=new RecursiveTaskDemo(arr,start,mid);
            RecursiveTaskDemo right=new RecursiveTaskDemo(arr,mid,end);

            left.fork();//run a subtask in parallel,submits the task in forkjoin pool to run asynchronously
            int rightResult=right.compute();//right task computes directly
            int leftResult=left.join();//wait and get the result after successful completion,always used with fork
            return rightResult+leftResult;
        }
    }


}
