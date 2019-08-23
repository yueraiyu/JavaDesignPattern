package com.yeay.design.builder.instance.entity;

import com.yeay.design.iterator.instance.Book;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            Book book = new Book("book" + "_" + Thread.currentThread().getName());
            System.out.println(book.getName());
        };

        int i = 0;
        while (true){
            Thread t = new Thread(r);
            t.start();
            if (i % 10 == 0){
//                System.gc();
                Book book = new Book("book" + "_" + i);
                System.out.println(book.getName());
                String s = "test" + i;
                System.out.println(s.intern());
            }
            Thread.sleep(100000);
            i ++;
        }
    }
}
