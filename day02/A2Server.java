import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class A2Server {
    static final int PORT = 4000;
    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;

    A2Server() {
        try {
            ss = new ServerSocket(PORT);
            System.out.println("Opened port " + PORT);
            s = ss.accept();
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            System.err.println(e);
        }
        InetAddress ia = s.getInetAddress();
        System.out.println(ia.getHostAddress());
        listen();
        
    }

    void speak() {
        String msg = null;
        
        

    }

    void listen() {
        String msg = null;
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.err.println(e);
        }

        System.out.println("Client: " + msg);
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
    }
}