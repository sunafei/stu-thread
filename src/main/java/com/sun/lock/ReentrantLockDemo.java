package com.sun.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static int count = 1;
    private static Lock lock = new ReentrantLock();

    static class CustomThread implements Runnable {
        public void run() {
            lock.lock();
            try {
                count++;
                System.out.println(Thread.currentThread().toString() + ": " + count + "占用三秒钟");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CustomThread());
        Thread thread2 = new Thread(new CustomThread());
        thread.start();
        thread2.start();
    }
}