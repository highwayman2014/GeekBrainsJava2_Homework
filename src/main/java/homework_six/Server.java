package homework_six;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args){

        ServerSocket server = null; // сервер
        Socket socket = null; // хост

        try {
            server = new ServerSocket(7777);
            System.out.println("Server started");
            socket = server.accept();
            System.out.printf("Client [%s] connected\n", socket.getInetAddress());

            Scanner scanner = new Scanner(System.in);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Поток для вывода входящих сообщений
            new Thread(()->{
                while (true){
                    String inStr = null;
                    try {
                        inStr = in.readUTF();
                        if("/end".equals(inStr)){
                            System.out.printf("Client disconnected\n");
                            break;
                        }else {
                            System.out.printf("Client - '%s'\n", inStr);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true){
                // Отправим исходящее сообщение
                String outStr = scanner.nextLine();
                try {
                    out.writeUTF(outStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
