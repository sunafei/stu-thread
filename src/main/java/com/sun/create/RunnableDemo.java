package com.sun.create;

public class RunnableDemo implements  Runnable{
    private String name;

    public RunnableDemo(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new Thread(new RunnableDemo("A")).start();
        new Thread(new RunnableDemo("B")).start();
    }
}
