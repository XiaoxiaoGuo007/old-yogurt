package com.example.yogurtlearn.java8new.funcationinterface;

import java.util.function.Consumer;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/7/23 17:41
 */
public class FunctionInterfaceTest {

    //1. Consumer
    public static void consumer(){
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(x);
            System.out.println(a);
        };
        consumer.accept(10);
    }



    public static void main(String[] args) {
        consumer();

    }

}
