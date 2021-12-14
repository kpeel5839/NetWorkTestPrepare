package chap;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import chap.Client.*;
//import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        int PORT = 55;
        ServerSocket server = new ServerSocket(PORT);
        while(true){
            try(Socket socket = server.accept()){
                ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)reader.readObject();
                System.out.println(message.message);
//                Date now = (Date)reader.readObject();
//                System.out.println(now);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
