package publisher;

import publisher.service.PublisherServiceImpl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Publisher extends Thread{
    private DatagramSocket socket;
    private Boolean running;
    private PublisherServiceImpl service;
    private byte[] buffer = new byte[256];

    public Publisher() throws SocketException {
        socket = new DatagramSocket(4445);
        service = new PublisherServiceImpl();
    }

    @Override
    public void run() {
        running = true;

        while(running) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
                packet = new DatagramPacket(buffer, buffer.length, packet.getAddress(), packet.getPort());
                byte[] result = this.service.returnMathResult(new String(packet.getData()));
                packet.setData(result);
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
