package com.demo.email.controller;

import java.util.ArrayList;
import java.util.List;

public class TestOperation {

    private List list = new ArrayList();
    static TestOperation to = new TestOperation();

    public synchronized void get() throws InterruptedException {
        if(list.size()==0){
            to.wait();

        } else {
            list.remove(0);
            to.notify();

        }
        System.out.println(Thread.currentThread().getName()+"******"+list.size());
    }

    public synchronized void add () throws InterruptedException {
        if(list.size()==100){
            to.wait();

        } else {
            list.add(0);
            to.notify();
        }
        System.out.println(Thread.currentThread().getName()+"******"+list.size());
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        to.add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        to.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        to.add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        to.add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t4.setName("t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
