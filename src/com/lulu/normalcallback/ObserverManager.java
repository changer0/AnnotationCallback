package com.lulu.normalcallback;


/**
 * @author zhanglulu on 2020/8/26.
 * for
 *
 *
 */
public class ObserverManager {
    public static void addObserver(final Observer observer) {
        observer.call();
    }
}
