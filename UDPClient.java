package assignment8;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 7000;

        DatagramSocket clientSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a lowercase string: ");
            String message = scanner.nextLine();

            byte[] sendData = message.getBytes();
            InetAddress serverIPAddress = InetAddress.getByName(SERVER_ADDRESS);

            // Send data
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, SERVER_PORT);
            clientSocket.send(sendPacket);

            // Prepare to receive
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Response from server: " + response);

    }
}

