package ForkJoinPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinWithParallelStream {
    public void forkJoinWithParallelStreamDemo() throws ExecutionException, InterruptedException {
//        List<Integer> numbers= new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(5);
//        numbers.add(6);
//        numbers.add(7);
//        numbers.add(8);
//        numbers.add(9);
//        numbers.add(10);
//
//        //sequential sum
//        int seqSum=numbers.stream().mapToInt(Integer::intValue).sum();
//        System.out.println("Sequential Sum "+seqSum);
//
//        //parallel sum-uses ForkJoinPool.commonPool internally
//        int parallelSum=numbers.parallelStream().mapToInt(Integer::intValue).sum();
//        System.out.println("Parallel sum "+parallelSum);


        ForkJoinPool customPool=new ForkJoinPool(4);
        int result=customPool.submit(()->
                IntStream.rangeClosed(1,10)
                        .parallel()
                        .map(val->{
                            System.out.println("Processing "+val+" on "+Thread.currentThread().getName());
                            return val;
                        }).sum()).get();
        System.out.println("Custom pool result is "+result);
        customPool.shutdown();


    }
}
