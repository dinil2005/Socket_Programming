import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {


        try {
            ServerSocket serverSocket = new ServerSocket();
            Socket socket = new Socket("localhost",9002);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String massage  ="";
            String reply ="";

            while (!massage.equals("finish")){
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
                massage=dataInputStream.readUTF();
                System.out.println(massage);

            }
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
