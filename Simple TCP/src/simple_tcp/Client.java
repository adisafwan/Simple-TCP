package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public Client() throws Exception{
        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successfully connected to the server!");

        // I/O Buffers
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String receivedMessage = in_socket.readLine();
        System.out.println("Server say: " + receivedMessage);
        out_socket.println("Thanks");

        socket.close();
        System.out.println("Socket close!");
    }

    public static void main(String[] args) {
        try {
            new Client();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
