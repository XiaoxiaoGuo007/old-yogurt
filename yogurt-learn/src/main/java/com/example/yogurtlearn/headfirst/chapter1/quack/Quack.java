package com.example.yogurtlearn.headfirst.chapter1.quack;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("呱呱叫!!!");
    }
}
