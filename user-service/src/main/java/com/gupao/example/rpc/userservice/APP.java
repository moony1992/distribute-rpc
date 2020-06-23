package com.gupao.example.rpc.userservice;

import com.gupaoedu.example.IOrderService;

public class APP {
    public static void main(String[] args) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IOrderService orderService = rpcProxyClient.clientProxy(IOrderService.class, "localhost", 8080);

        System.out.println(orderService.queryOrderList());
        System.out.println("22");
    }
}
