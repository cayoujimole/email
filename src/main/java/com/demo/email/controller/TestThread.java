package com.demo.email.controller;

public class TestThread extends Thread {

    static TestThread tt = new TestThread();
    static int i = 0;
    @Override
    public void run() {

        for (int j = 0; j < 100000; j++) {
            synchronized (tt){
                i++;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);
        Thread t3 = new TestThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
