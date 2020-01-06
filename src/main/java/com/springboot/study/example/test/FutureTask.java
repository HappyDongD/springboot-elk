package com.springboot.study.example.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTask {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(() -> {
            int a=0;
            for (int i = 0; i < 20; i++) {
                a = i + 3;
                System.out.println("这是a的值："+a);
            }
            return a;
        });
        for (int i=0;i<10;i++){
            System.out.println("这是i的值："+i);
        }

        try {
            Integer integer = future.get();
            System.out.println("iiiiii---->>>"+integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
