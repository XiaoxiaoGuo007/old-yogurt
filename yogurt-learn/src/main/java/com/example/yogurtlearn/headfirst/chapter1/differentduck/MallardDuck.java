package com.example.yogurtlearn.headfirst.chapter1.differentduck;


import com.example.yogurtlearn.headfirst.chapter1.Duck;
import com.example.yogurtlearn.headfirst.chapter1.fly.FlyWithWings;
import com.example.yogurtlearn.headfirst.chapter1.quack.Quack;

/**
 * 绿头鸭
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack(); // 呱呱叫
        flyBehavior = new FlyWithWings(); //会飞
    }

    //外观
    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck!");
    }
}
