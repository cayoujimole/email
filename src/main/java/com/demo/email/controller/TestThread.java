package com.demo.email.controller;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestThread extends Thread {

    static TestThread tt = new TestThread();
    static int i = 0;
    @Override
    public void run() {

        for (int j = 0; j < 100000; j++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        tt.testStream2();
    }

    public void testStream2() {
        List<Long> list = new ArrayList<>();
        int i = 100;
        while( i > 0){
            i--;
            list.add(Long.valueOf(i));
        }
        list.forEach(l->{
            System.out.println(l);
        });
        System.out.println("@@@@@@@@@@@@@@@stream@@@@@@@@@@@@@@@");
        Stream stream = list.stream().filter((num)->{
            return num >50;
        });
        List<Long> newList = (List)stream.collect(Collectors.toList());

        newList.forEach(l->{
            System.out.println(l);
        });
    }

    public void testStream() {
        Instant start = Instant.now();
        //使用StreamAPI
        OptionalLong result = LongStream.rangeClosed(0L, 50000000000L).parallel().reduce(Long::sum);
        System.out.println(result.getAsLong());
        Instant end = Instant.now();
        System.out.println("五百亿求和耗费的时间为: " + Duration.between(start, end).toMillis());

    }

}

class xxx{

}