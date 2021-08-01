package com.example.yogurtlearn.headfirst.chapter1.fly;

import com.example.yogurtlearn.headfirst.chapter1.fly.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't flying!!!");
    }
}
