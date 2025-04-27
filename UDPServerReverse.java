package assignment8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerReverse{
    public static void main(String[] args) throws Exception{

        DatagramSocket serverSocket = new DatagramSocket(7000);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("UDP Server is running...");

            while (true) {

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String receivedString = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + receivedString);


                String reversedString = new StringBuilder(receivedString).reverse().toString();
                sendData = reversedString.getBytes();

                // Send back to client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                System.out.println("Sent reversed string: " + reversedString);
            }
    }
}

