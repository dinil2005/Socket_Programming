import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) {
        try {


            ServerSocket serverSocket = new ServerSocket(9002);
            Socket LocalSocket = serverSocket.accept();
            System.out.println("Client Accepted");
            DataInputStream dataInputStream = new DataInputStream(LocalSocket.getInputStream());// Data read
            DataOutputStream dataOutputStream = new DataOutputStream(LocalSocket.getOutputStream());// Data Write
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//Line by line read. only assgine dataInput stream types
            String massage = "";
            String reply = "";

            while (!massage.equals("finish")){
                massage=dataInputStream.readUTF();
                System.out.println("Client Message : "+massage);
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
            }
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
