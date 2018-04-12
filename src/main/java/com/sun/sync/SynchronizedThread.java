package com.sun.sync;

public class SynchronizedThread {
    public static void main(String[] args) {
        Sync sync = new Sync();
        new Thread(sync).start();
        new Thread(sync).start();
    }

    static class Sync implements Runnable{

        public void run() {
            synchronized (this) {
                try {
                    System.out.println(Thread.currentThread().getName() + "线程单独占用5秒钟");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
