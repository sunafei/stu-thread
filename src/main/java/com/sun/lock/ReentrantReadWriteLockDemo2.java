package com.sun.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo2 {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReentrantReadWriteLockDemo2 test = new ReentrantReadWriteLockDemo2();
        new Thread("O") {
            public void run() {
                test.write(Thread.currentThread());
            };
        }.start();
        new Thread("A") {
            public void run() {
                test.read(Thread.currentThread());
            };
        }.start();

        new Thread("B") {
            public void run() {
                test.read(Thread.currentThread());
            };
        }.start();

        new Thread("C") {
            public void run() {
                test.write(Thread.currentThread());
            };
        }.start();
        new Thread("D") {
            public void run() {
                test.read(Thread.currentThread());
            };
        }.start();
    }

    public void read(Thread thread) {
        rwl.readLock().lock(); // 在外面获取锁
        try {
            System.out.println("线程" + thread.getName() + "开始读操作...");
            System.out.println("线程" + thread.getName() + "正在进行读操作...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + thread.getName() + "读操作完毕...");
        } finally {
            rwl.readLock().unlock();
        }
    }

    public void write(Thread thread) {
        rwl.writeLock().lock(); // 在外面获取锁
        try {
            System.out.println("线程" + thread.getName() + "开始写操作...");
            System.out.println("线程" + thread.getName() + "正在进行写操作...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + thread.getName() + "写操作完毕...");
        } finally {
            rwl.writeLock().unlock();
        }
    }
}
