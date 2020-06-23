package com.gupao.example.rpc.userservice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcProxyClient {
//    public <T> T cilendProxy(final Class<T>interfaceCls,final String host,final int port){
//        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls},new RemoteInvocationHandler(host,port));
//            }
//        });
//    }
    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls},new RemoteInvocationHandler(host,port));
    }
}
