package com.example.yogurtlearn.headfirst.chapter1;

import com.example.yogurtlearn.headfirst.chapter1.fly.FlyBehavior;
import com.example.yogurtlearn.headfirst.chapter1.quack.QuackBehavior;

/**
 * 1. 让鸭子易变得行为单独崇抽离出来
 *    1.1 fly : 有的鸭子可以飞，有的不可以飞  单独写一份FlyBehavior接口，具体可不可以飞的行为由子类实现
 *    1.2 quack：有的 呱呱叫，有的 咯咯叫，有的 不会叫 ，单独写一个 QuackBehavior接口，由具体的子类去实现
 */
public abstract class Duck {
    //鸭子的飞行行为
    public FlyBehavior flyBehavior;
    //鸭子的叫声
    public QuackBehavior quackBehavior;

    public abstract void display();
    //调用鸭子的声音,具体的实现在QuackBehavior的子类中
    public void performQuack(){
        quackBehavior.quack();
    }

    //调用鸭子的飞行行为，具体的实现在FlyBehavior的子类实现
    public void performFly(){
        flyBehavior.fly();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys");
    }

    //fly
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    //quack
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
