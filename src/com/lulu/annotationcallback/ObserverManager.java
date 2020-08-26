package com.lulu.annotationcallback;

import java.lang.reflect.Method;

/**
 * @author zhanglulu on 2020/8/26.
 * for
 */
public class ObserverManager {

    private static final String TAG = "ObserverManager";

    public static void addObserver(final Observer observer) {
        Class<? extends Observer> clazz = observer.getClass();
        Method[] methods = clazz.getMethods();
        Method successMethod = null, failureMethod = null;
        //遍历所有方法，找到被注解的方法
        for (Method method : methods) {
            ObserverEvent annotation = method.getAnnotation(ObserverEvent.class);
            if (annotation == null) {
                continue;
            }
            if (annotation.value() == ObserverEvent.Event.SUCCESS) {
                successMethod = method;
            } else if (annotation.value() == ObserverEvent.Event.FAILURE) {
                failureMethod = method;
            }
        }
        //直接执行成功回调
        if (successMethod != null) {
            try {
                successMethod.invoke(observer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //延迟执行失败
        if (failureMethod != null) {
            try {
                Thread.sleep(2000);
                failureMethod.invoke(observer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
