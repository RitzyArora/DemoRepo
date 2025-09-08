package ExecutorFramework;

import jdk.jfr.Timestamp;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CompletableFutureTimeoutDemo {

    public void simpleCompletableFutureUsage() throws InterruptedException{
        CompletableFuture<String> pipeline=CompletableFuture.supplyAsync(()->{
            System.out.println("Step 1->Fetching data");
            System.out.println(LocalDateTime.now());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Some Work";
        }).thenApply(d->{
            System.out.println("Step 2->Transform data");
            return d.toUpperCase();
        });

        System.out.println("Result is "+pipeline.join());


        System.out.println("---------------------------------------------");
        CompletableFuture<String> withTimeOut=CompletableFuture.supplyAsync(()->{
                    System.out.println(LocalDateTime.now());
            System.out.println("Starting slower task");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "slow result";
        }).orTimeout(1, TimeUnit.SECONDS)
                .exceptionally(ex->{
                    System.out.println("Task failed: "+ex);
                    return "fallback value";
                });
        System.out.println("Result with timeout is "+withTimeOut.join());
        System.out.println("------------------------------------------");
        CompletableFuture<String> fallbackOnTimeout=CompletableFuture.supplyAsync(()->{
            System.out.println("Starting another slow task");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Some more work";
        }).completeOnTimeout("default-value",1,TimeUnit.SECONDS);
        System.out.println(fallbackOnTimeout.join());


    }
}
