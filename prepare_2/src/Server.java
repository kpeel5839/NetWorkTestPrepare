import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int PORT = 55;
        ServerSocket server = new ServerSocket(PORT);
        while(true){
            try(Socket socket = server.accept()){
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream() , "UTF-8"));
                StringBuilder st = new StringBuilder();
                while(true){
                    int c = reader.read();
                    if(c == -1) break;
                    st.append((char)c);
                }
                System.out.println(st);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
