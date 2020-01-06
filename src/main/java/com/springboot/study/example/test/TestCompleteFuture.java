package com.springboot.study.example.test;

import java.util.concurrent.CompletableFuture;

/**
 * CompleteFuture各个方法学习
 */
public class TestCompleteFuture {
    public static void main(String[] args) {
        //Function，入参T，出参V
        String join = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        }).thenApplyAsync(a -> a + "world").join();
        System.out.println(join);

        //Consumer ，入参T，无出参
        CompletableFuture.supplyAsync(() -> {
            return "Consumer";
        }).thenAcceptAsync(c -> System.out.println("消费：" + c));
    }
}
