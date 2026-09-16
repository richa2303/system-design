package com.example.practice.system_design.design_patterns.creational_pattern;

public class SingletonDesignPattern {

    private SingletonDesignPattern(){
    }

    private static volatile SingletonDesignPattern instance;

    public static SingletonDesignPattern getInstance(){
        if(instance == null) {
            synchronized (SingletonDesignPattern.class) {
                if (instance == null) {
                    instance = new SingletonDesignPattern();
                }
            }
        }
        return instance;
    }
}
