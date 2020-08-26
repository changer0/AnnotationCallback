package com.lulu.annotationcallback;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhanglulu on 2020/8/26.
 * for
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ObserverEvent {
    public enum Event {
        SUCCESS, FAILURE
    }
    Event value();
}
