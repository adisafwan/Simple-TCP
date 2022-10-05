package simple_tcp;

// Importing IOException class and ServerSocket class
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2020); // Open new port *Port 2020 is a UDP port for datagram protocol
        System.out.println("Port 2020 is open");

        Socket socket = serverSocket.accept(); // accept() here is a blocking method where when Java is running through this code, when it comes to this line, it will waiting for incoming connection then only it will continue to the other lines
        System.out.println("Client: " + socket.getInetAddress() + " has connected."); // getInetAddress is to retrieve the client's IP address from the socket object

        // I/O Buffers - A place to store our data in and out of the socket
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        out_socket.println("Welcome!"); // print message when client is connected to server
        String message = in_socket.readLine(); // store reply from client to message object
        System.out.println("Client reply: " + message);

        socket.close();
        System.out.println("The socket has closed");
    }

    public static void main(String[] args) {
        try {
            new Server();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
