package com.gupaoedu.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class ProcessorHandler implements Runnable{

    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream=null;
        ObjectOutputStream outputStream=null;
        try {
            inputStream=new ObjectInputStream(socket.getInputStream());//?
            RpcRequest request=(RpcRequest)inputStream.readObject(); //反序列化
            //路由
            Mediator mediator=Mediator.getInstance();
            Object rs=mediator.processor(request);
            System.out.println("服务端的执行结果："+rs);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rs);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //TODO 关闭流
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
