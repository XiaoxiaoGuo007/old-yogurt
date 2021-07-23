package com.example.yogurtlearn.java8new.constructor;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import io.lettuce.core.cluster.api.push.RedisClusterPushListener;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * @from :https://blog.csdn.net/qq_28410283/article/details/80963351
 * @description:
 *  在lambda表达式中，使用方法的引用，来传递方法方法的行为参数化
 *  方法的引用的语法，主要有三类:
 *      1.指向静态方法的方法引用，例如Integer的parseInt方法 ，可以写成Integer::parseInt
 *           类：：静态方法名
 *      2.指向任意类型实例方法的方法引用，例如String的length方法，写成String::length；
 *          类：：实例方法名
 *      3.指向现有对象的实例方法的方法引用
 *          对象：：实例方法名
 *
 *   构造器的引用:
 *      对于一个现有构造函数，你可以利用它的名称和关键字new来创建它的一个引用ClassName::new；
 *      在java8中的函数式接口，提供了无参构造函数，以及有参构造函数创建实例的方式；
 *      构造器的参数列表，需要与函数式接口中参数列表保持一致！
 * @author: old_yogurt
 * @date 2021/7/23 16:42
 */
public class ConstructorTest {


    // 类：：静态方法名
    public static void test1(){
        // compare(a,b)->
        // a==b -> 0 ; a>b -> 1 ; a<b -> -1
        Comparator<Integer> c = Integer::compare;
        System.out.println(c.compare(3, 2));
        Comparator<Integer> cc = (x, y) -> Integer.compare(x, y);
        System.out.println(cc.compare(3, 2));

        Comparator<Integer> d = (x,y) -> x.compareTo(y);
        System.out.println(d.compare(3, 2));
        Comparator<Integer> dd = Integer::compareTo;
        System.out.println(dd.compare(3, 2));
    }

    // 类：：实例方法名
    public static void test2(){
        BiPredicate<String,String> co = (x, y) -> x.equals(y);
        System.out.println(co.test("a", "b"));

        BiPredicate<String, String> coo = String::equals;
        System.out.println(coo.test("a", "a"));
    }

    // 对象：：实例方法名
    public static void test3(){
        Consumer<String> out = x -> System.out.println(x);
        out.accept("abc");
        Consumer<String> out2 = System.out::println;
        out.accept("abc");

        System.out.println("-------");
        Emp emp = new Emp("深圳","yogurt",18);
        Supplier<String> supper = () -> emp.getAddress();
        System.out.println(supper.get());
        Supplier<String> supper1 = emp::getAddress;
        System.out.println(supper1.get());
    }


    /*************** 构造器的引用 ****************/
    public static void test4(){
        // 无参构造函数，创建实例
        Supplier<Emp> empSupplier = () -> new Emp();
        Supplier<Emp> empFunction = Emp::new;
        Emp emp1 = empSupplier.get();
        Emp emp2 = empFunction.get();
        emp1.setAddress("武汉");
        emp2.setAddress("长沙");
        System.out.println("emp1:"+emp1.getAddress()+",emp2:"+emp2.getAddress());

        System.out.println("-------");
        //一个参数
        Function<String,Emp> fun = address -> new Emp(address);
        Function<String, Emp> fun1 = Emp::new;
        Function<Integer, Emp> fun2 = Emp::new;
        System.out.println(fun.apply("beijing"));
        System.out.println(fun1.apply("xuchang"));
        System.out.println(fun2.apply(18));

        // 两个参数
        BiFunction<String,Integer,Emp> biFunction = (name, age) -> new Emp(name, age);
        BiFunction<String, Integer, Emp> biFunction1 = Emp::new;
        System.out.println(biFunction1.apply("yogurt", 18));

    }


    public static void main(String[] args) {
        test1();
        System.out.println("-----------------");
        test2();
        System.out.println("-----------------");
        test3();
        System.out.println("-----------------");
        test4();
    }



    static class Emp {
        private String address;

        private String name;

        private Integer age;

        public Emp() {

        }

        public Emp(Integer age) {
            this.age = age;
        }

        public Emp(String address) {
            this.address = address;
        }

        public Emp(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Emp(String address, String name, Integer age) {
            super();
            this.address = address;
            this.name = name;
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Emp [address=" + address + ", name=" + name + ", age=" + age + "]";
        }

    }
}


