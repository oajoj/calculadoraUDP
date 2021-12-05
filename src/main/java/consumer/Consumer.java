package consumer;

import consumer.service.ConsumerServiceImpl;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Consumer {

    private ConsumerServiceImpl service;

    public Consumer() throws SocketException, UnknownHostException {
        this.service = new ConsumerServiceImpl();
    }

    public void sendMessage(String msg) throws IOException {
        String result = this.service.sendMessage(msg);
        System.out.println(result);
    }

    public void closeSocket(){
        this.service.closeSocket();
    }
}
