package com.sun.threadLocal;
import org.junit.Test;

public class ThreadLocalDemo {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    Long val = 3L;

    public void set() {
        longLocal.set(val);
    }

    public String get() {
        return Thread.currentThread().getName() + longLocal.get();
    }

    @Test
    public void aa() {
        LocalThread localThread = new LocalThread(3);
        new Thread(localThread, "A").start();
        LocalThread localThread1 = new LocalThread(4);
        new Thread(localThread1, "B").start();
        set();
        System.out.println(get());
    }

    class LocalThread implements Runnable {
        private int a = 0;

        public LocalThread(int a) {
            this.a = a;
        }

        public void run() {
            set();
            Long val = longLocal.get();
            val = val - a;
        }

    }
}
