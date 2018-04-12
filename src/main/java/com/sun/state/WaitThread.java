package com.sun.state;

public class WaitThread extends Thread {
    public synchronized void notifys() {
        this.notify();
    }

    @Override
    public synchronized void run() {
        try {
            System.out.println("主动释放对象锁，同时本线程休眠");
            this.wait();
            System.out.println("继续执行线程内容");
            System.out.println("XXXXX");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        WaitThread waitThread = new WaitThread();
        waitThread.start();
        System.out.println("5秒后触发");
        Thread.sleep(5000);
        waitThread.notifys();
    }
}
