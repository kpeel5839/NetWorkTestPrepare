import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server { //그냥 no multi thread
    public static void main(String[] args) throws IOException {
        int PORT = 55;
        try(ServerSocket server = new ServerSocket(PORT)){
            ExecutorService executor = Executors.newFixedThreadPool(200);
            while(true){
                try{
                    Socket socket = server.accept(); //try catch 에다가 하면 오류남
                    executor.submit(new MyThread(socket));
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static class MyThread implements Runnable{
        Socket socket;
        public MyThread(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run(){
            try(Socket autoClose = socket){
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream() , "UTF-8"));
                writer.write("hello");
                writer.write("\r\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}