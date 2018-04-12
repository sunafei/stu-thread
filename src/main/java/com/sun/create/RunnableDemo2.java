package com.sun.create;

public class RunnableDemo2 implements  Runnable{
    private int count = 15;

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        RunnableDemo2 thread = new RunnableDemo2();
        new Thread(thread, "A").start();
        new Thread(thread, "B").start();
    }
}
