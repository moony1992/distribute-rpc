package com.gupao.example.rpc.userservice;

import com.gupaoedu.example.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RpcNetTransport {
    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Socket newSocket() throws IOException {
        Socket socket = new Socket(host, port);
        return socket;
    }

    public Object send(RpcRequest request) {
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        try {
            Socket socket = newSocket();
            //IO操作
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();
            inputStream = new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //TODO 不写了
        }
        return  null;
    }
}