package com.sun.state;

/**
 *
 */
public class YieldThread {
    public static void main(String[] args) {
        new Yield("thread1").start();
        new Yield("thread2").start();
    }
}

class Yield extends Thread {

    /**
     * @param name
     */
    public Yield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("" + this.getName() + "======" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                this.yield();
            }
        }
    }
}