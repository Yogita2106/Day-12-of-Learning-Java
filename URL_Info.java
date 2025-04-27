package assignment8;

import java.net.URL;
public class URL_Info {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ");

        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Path: " + url.getPath());
        System.out.println("Query: " + url.getQuery());

    }
}

