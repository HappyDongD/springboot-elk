package com.springboot.study.example.test;

import java.util.Random;
import java.util.concurrent.*;


/**
 * @program: callable
 * @description: Test
 * @author: Mr.Wang
 * @create: 2018-08-12 11:37
 **/
public class MyTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> submit = executor.submit(() -> {
            return new Random().nextInt();
        });

        executor.shutdown();

        try {
            System.out.println("result1:" + submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}