import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static String HOST = "localhost";
    public static int PORT = 55;
    public static void main(String[] args) throws UnknownHostException, IOException {
        try (Socket socket = new Socket(HOST, PORT)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream() , "UTF-8"));
            writer.write("hello hello");
            writer.flush();
        } catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
//        for(int i = 0; i < 200; i++){
//            new Thread(new MyThread()).start();
//        }
    }
//    public static class MyThread implements Runnable{
//        @Override
//        public void run(){
//            try(Socket socket = new Socket(HOST, PORT)){
//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream() , "UTF-8"));
//                StringBuilder st = new StringBuilder();
//                while(true){
//                    String s = reader.readLine();
//                    if(s == null) break;
//                    st.append(s);
//                }
//                System.out.println(st);
//            } catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//    } 여기는 client가 thread를 이용하는 방법
}

