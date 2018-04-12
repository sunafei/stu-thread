package com.sun.state;

public class JoinThread implements Runnable {
    private String name;

    public JoinThread(String name) {
        super();
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + name + "运行 : " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }

    public static void main(String args[]) {
        // System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        // new Thread(new Thread4("A"), "C").start();
        // new Thread(new Thread4("B"), "D").start();
        // System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");

        System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
        Thread t1 = new Thread(new JoinThread("A"), "C");
        Thread t2 = new Thread(new JoinThread("B"), "D");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
    }
}