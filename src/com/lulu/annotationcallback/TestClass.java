package com.lulu.annotationcallback;

public class TestClass {

    public static void main(String[] args) {
        ObserverManager.addObserver(new Observer() {

            @ObserverEvent(ObserverEvent.Event.SUCCESS)
            public void callSuccess() {
                System.out.println("成功回调");
            }
            @ObserverEvent(ObserverEvent.Event.FAILURE)
            public void callFailure() {
                System.out.println("失败回调");
            }
        });
    }
}
