package consumer.service;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ConsumerServiceImpl implements ConsumerService{

    private DatagramSocket socket;
    private InetAddress address;
    private byte[] buffer;

    public ConsumerServiceImpl() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }

    @Override
    public String sendMessage(String msg) throws IOException {
        buffer = msg.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4445);
        socket.send(packet);

        byte[] resultByte = new byte[256];
        packet = new DatagramPacket(resultByte, resultByte.length);
        socket.receive(packet);
        return new String(packet.getData(), 0, packet.getLength());
    }

    @Override
    public void closeSocket() {
        socket.close();
    }
}
