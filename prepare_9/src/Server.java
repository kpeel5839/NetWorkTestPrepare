import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server { //그냥 no multi thread
    public static void main(String[] args) throws IOException {
        int PORT = 55;
        try(ServerSocket server = new ServerSocket(PORT)){
            while(true){
                try(Socket socket = server.accept()){
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream() , "UTF-8"));
                    writer.write("hello hello");
                    writer.write("\r\n");
                    writer.flush();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
