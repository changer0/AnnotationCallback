package com.lulu.normalcallback;

public class TestClass {

    public static void main(String[] args) {
        ObserverManager.addObserver(new Observer() {
            @Override
            public void call() {
                System.out.println("被调用～");
            }
        });
    }
}
