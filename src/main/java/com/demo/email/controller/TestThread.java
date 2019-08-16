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

    /**
     * 写好多注释哦
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(tt);
//        Thread t2 = new Thread(tt);
//        Thread t3 = new TestThread();
//        t1.start();
//        t2.start();
//        t3.start();
//        t1.join();
//        t2.join();
//        System.out.println(i);
        String s1 = "hello world";
        String s2 = new String("hello world");
        System.out.println(s1 == s2);
        s2.intern();
        System.out.println(s1 == s2);
    }

}
