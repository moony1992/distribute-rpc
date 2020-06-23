package com.gupaoedu.example;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
//spring 容器启动完成之后，会发布一个ContextRefreshedEvent=
@Component
public class SocketServerInitial implements ApplicationListener<ContextRefreshedEvent>{
    private final ExecutorService executorService= Executors.newCachedThreadPool();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //启动服务
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(8888);
            while(true){
                Socket socket=serverSocket.accept(); //监听客户端请求
                executorService.execute(new ProcessorHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
