package com.springboot.study.example.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    public double getPrice(String product) {
       return calculatePrice(product);
    }

    public double calculatePrice(String product) {
        delay();
        return Math.random() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(()->{
            double price =calculatePrice(product);
            future.complete(price);
        }).start();
        return future;
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
