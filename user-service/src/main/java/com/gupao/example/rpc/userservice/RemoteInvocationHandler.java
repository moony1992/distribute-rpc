package com.gupao.example.rpc.userservice;

import com.gupaoedu.example.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //先建立远程连接
        RpcNetTransport rpcNetTransport=new RpcNetTransport(host,port);
        //传递数据了？
        // 调用哪个接口、 哪个方法、方法的参数？
        RpcRequest request=new RpcRequest();
        request.setArgs(args);
        request.setClassName(method.getDeclaringClass().getName());
        request.setTypes(method.getParameterTypes()); //参数的类型
        request.setMethodName(method.getName());
        return rpcNetTransport.send(request);
    }
}
