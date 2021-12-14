package chap;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Client {
    public static class Message implements Serializable{
        private static final long serialVersionUID = 1L; //serialVersionUID 없으면 에러남
        String message;
        public Message(String message){
            super(); //이게 있었어야 했음
            this.message = message;
        }
    }
    public static void main(String[] args) throws UnknownHostException, IOException {
        String HOST = "localhost";
        int PORT = 55; //그냥 임의로 정한 포트 번호임
        try (Socket socket = new Socket(HOST, PORT)) {
            ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
            writer.writeObject(new Message("안녕?"));
//            writer.writeObject(new Date());
            writer.flush(); //객체는 그냥 write 한다음 \r\n x하고 그냥 flush
        }catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
