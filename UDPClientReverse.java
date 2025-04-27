package assignment8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientReverse {
        public static void main(String[] args) throws Exception{
            final int SERVER_PORT = 7000;
            DatagramSocket clientSocket = new DatagramSocket();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a string to reverse: ");
                String message = scanner.nextLine();

                byte[] sendData = message.getBytes();
                InetAddress serverIPAddress = InetAddress.getByName("localhost");

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, SERVER_PORT);
                clientSocket.send(sendPacket);


                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String reversedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Reversed string from server: " + reversedMessage);

        }
    }


