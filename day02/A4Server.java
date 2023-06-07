import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class A4Server {
    int port = 4567;
    ServerSocket ss;
    Socket s;
    String ipClient;

    InputStream is;
    DataInputStream dis;

    A4Server() {
        try {
            ss = new ServerSocket(port);
            System.out.println(port + "waiting");
            s = ss.accept();
            InetAddress ia = s.getInetAddress();
            ipClient = ia.getHostAddress();
            System.out.println(ipClient + " connected");

            is = s.getInputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dis = new DataInputStream(is);

        listen();
    }

    void listen() {
        String msg = "";
        
        while (true) {
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Client>> " + msg);
        }
    }

    public static void main(String[] args) {
        A4Server server = new A4Server();
    }
}
