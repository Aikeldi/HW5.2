package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passengers extends Thread {
    private CountDownLatch countDownLatch;
    private Semaphore semaphore;

    public Passengers(String name, CountDownLatch countDownLatch, Semaphore semaphore) {
        super(name);
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {

            semaphore.acquire();
            System.out.println(getName() + "встал в очередь на кассу");
            sleep(2000);
            System.out.println(getName() + " купил билет");
            sleep(2000);
            System.out.println(getName() + "сел в автобус");
            countDownLatch.countDown();
            semaphore.release();
        } catch (Exception e) {
        }

    }
}
