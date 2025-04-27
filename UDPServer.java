package assignment8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception{

        DatagramSocket serverSocket = new DatagramSocket(7000);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("UDP Server is running and waiting for a message...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + clientMessage);

                String upperCaseMessage = clientMessage.toUpperCase();
                sendData = upperCaseMessage.getBytes();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                System.out.println("Sent back: " + upperCaseMessage);
            }

    }
}
