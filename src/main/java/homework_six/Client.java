package homework_six;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import java.util.Scanner;

public class Client {

    public static final String ADDRESS = "localhost";
    public static final int PORT = 7777;

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket(ADDRESS, PORT);
            boolean connectionClosed = false;
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            // Поток для вывода входящих сообщений
            Thread t1 = new Thread(() -> {
                while (true) {
                    String inStr = null;
                    try {
                        inStr = in.readUTF();
                        System.out.printf("Server - '%s'\n", inStr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.start();

            while (true) {
                // Отправим исходящее сообщение
                String outStr = scanner.nextLine();
                try {
                    out.writeUTF(outStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if ("/end".equals(outStr)) {
                    t1.stop();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
