package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        Semaphore semaphore = new Semaphore(4, true);
        for (int i = 1; i < 101; i++) {
            new Passengers("Пассажир" + i, countDownLatch, semaphore).start();

        }
        try {
            countDownLatch.await();
            System.out.println("Автобус начал движение");

        } catch (Exception e) {
        }

    }
}
