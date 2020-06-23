package com.gupaoedu.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@Component
public class InitialMerdiator implements BeanPostProcessor{

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //
        if(bean.getClass().isAnnotationPresent(GpRemoteService.class)){ //加了服务发布标记的bean进行远程发布
            Method[] methods=bean.getClass().getDeclaredMethods();
            for(Method method:methods){
                String key=bean.getClass().getInterfaces()[0].getName()+"."+method.getName();
                BeanMethod beanMethod=new BeanMethod();
                beanMethod.setBean(bean);
                beanMethod.setMethod(method);
                Mediator.map.put(key,beanMethod);
            }
        }
        return bean;
    }
}
