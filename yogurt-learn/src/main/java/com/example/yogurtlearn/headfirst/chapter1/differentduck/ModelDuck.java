package com.example.yogurtlearn.headfirst.chapter1.differentduck;

import com.example.yogurtlearn.headfirst.chapter1.Duck;
import com.example.yogurtlearn.headfirst.chapter1.fly.FlyNoWay;
import com.example.yogurtlearn.headfirst.chapter1.quack.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
