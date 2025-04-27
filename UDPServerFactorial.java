package assignment8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerFactorial {
    public static void main(String[] args) throws Exception{
      DatagramSocket serverSocket = new DatagramSocket(7000);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("UDP Server is running...");

            while (true) {
                // Receive data
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received number: " + received);

                // Calculate factorial
                int number = Integer.parseInt(received.trim());
                long factorial = 1;
                for (int i = 2; i <= number; i++) {
                    factorial *= i;
                }

                String result = "Factorial of " + number + " is " + factorial;
                sendData = result.getBytes();

                // Send result back to client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                System.out.println("Sent: " + result);
            }

    }
}
