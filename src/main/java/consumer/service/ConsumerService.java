package consumer.service;

import java.io.IOException;

public interface ConsumerService {
    public String sendMessage(String msg) throws IOException;
    public void closeSocket();
}
