package com.example.yogurtlearn.headfirst.chapter1.quack;

public class MuteQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("哑巴...");
    }
}
