package com.example.yogurtlearn.headfirst.chapter1;

import com.example.yogurtlearn.headfirst.chapter1.differentduck.MallardDuck;
import com.example.yogurtlearn.headfirst.chapter1.differentduck.ModelDuck;
import com.example.yogurtlearn.headfirst.chapter1.fly.FlyRocketPowered;

public class TestDuck {
    public static void main(String[] args) {
//        Duck mallardDuck = new MallardDuck();
//        mallardDuck.performFly();
//        mallardDuck.performQuack();


        //下面是两种方式获取飞行行为
        Duck model = new ModelDuck();
        model.performFly();
        System.out.println("----------");
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
