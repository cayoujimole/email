package com.demo.email.controller;

public class TestRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"******"+i);
        }
    }

    /**
     * dev
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable tr = new TestRunnable();
        Thread t1 = new Thread(tr);
        Thread t2 = new Thread(tr);
        Thread t3 = new Thread(tr);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();
//        t3.start();
//        t3.join();
        t1.setPriority(1);
        t2.setPriority(2);
        t3.setPriority(3);
        t1.start();
        t2.start();
        t3.start();
    }

}
