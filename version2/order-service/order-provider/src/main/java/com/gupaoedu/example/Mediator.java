package com.gupaoedu.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class Mediator {

    //用来存储发布的服务的实例(服务调用的路由)
    public static Map<String ,BeanMethod> map=new ConcurrentHashMap<>();

    private volatile static Mediator instance;

    private Mediator(){};

    public static Mediator getInstance(){
        if(instance==null){
            synchronized (Mediator.class){
                if(instance==null){
                    instance=new Mediator();
                }
            }
        }
        return instance;
    }

    public Object processor(RpcRequest request){
        String key=request.getClassName()+"."+request.getMethodName(); //key
        BeanMethod beanMethod=map.get(key);
        if(beanMethod==null){
            return null;
        }
        Object bean=beanMethod.getBean();
        Method method=beanMethod.getMethod();
        try {
            return method.invoke(bean,request.getArgs());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
