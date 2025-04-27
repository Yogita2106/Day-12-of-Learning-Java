package assignment8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientFactorial {
    public static void main(String[] args) throws Exception{

        final int SERVER_PORT = 7000;

        DatagramSocket clientSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an integer to calculate its factorial: ");
            int number = scanner.nextInt();

            // Convert number to bytes
            byte[] sendData = String.valueOf(number).getBytes();
            InetAddress serverIP = InetAddress.getByName("localhost");

            // Send number to server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, SERVER_PORT);
            clientSocket.send(sendPacket);

            // Receive factorial result
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + result);

    }
}

