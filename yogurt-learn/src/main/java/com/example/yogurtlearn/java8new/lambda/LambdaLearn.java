package com.example.yogurtlearn.java8new.lambda;

import com.mysql.cj.callback.MysqlCallbackHandler;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * @from: https://blog.csdn.net/qq_28410283/article/details/80961022
 * @description: lambda表达式
 *  java中，引入了一个新的操作符“->”，该操作符在很多资料中，称为箭头操作符，或者lambda操作符；
 *  箭头操作符将lambda分成了两个部分：
 *     1.左侧：lambda表达式的参数列表
 *     2.右侧：lambda表达式中所需要执行的功能，即lambda函数体
 *     3.lambda表达式语法格式；
 * @author: old_yogurt
 * @date 2021/7/22 15:36
 */
public class LambdaLearn {
    /**
     * 1）无参数，无返回值的用法 ：() -> System.out.println("hello lambda");
     */
    public static void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable");
            }
        };
        r.run();
        Runnable r1 = () -> System.out.println("hello lambda");
        r1.run();
    }

    /**
     * 2).有一个参数，无返回值的用法：
     *        (x) -> System.out.println(x);
     *        或者 x -> System.out.println(x); 一个参数，可以省略参数的小括号
     */
    public static void test2(){
        Consumer con = x -> System.out.println(x);
        con.accept("有一个参数，无返回值的用法（Consumer函数式接口）");
    }

    /**
     * 3）有两个参数，有返回值的：(x, y) -> x + y
     */
    public void test3(){
        BinaryOperator<Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(1,2));
    }

    /**
     * 多行的，只需要用大括号{}把语句包含起来就可以了；
     * 有返回值和无返回值的，只有一个return的区别；
     * 只有一条语句的，大括号和renturn都可以不用写。
     */
    public static void test4() {
        // 无返回值lambda函数体中用法
        Runnable r1 = () -> {
            System.out.println("hello lambda1");
            System.out.println("hello lambda2");
            System.out.println("hello lambda3");
        };
        r1.run();

        // 有返回值lambda函数体中用法
        BinaryOperator<Integer> binary = (x, y) -> {
            int a = x * 2;
            int b = y + 2;
            return a + b;
        };
        System.out.println(binary.apply(1, 2));// 6
    }


    public static void main(String[] args) {
        test4();
    }
}
