import java.io.DataInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class A5Server {
    int port = 4000;
    ServerSocket ss;
    Socket s;
    String ipClient;

    InputStream is;
    DataInputStream dis;

    A5Server() {
        ss = new ServerSocket(port);
        System.out.println(port + " waiting");
        s = ss.accept();
        InetAddress ia = s.getInetAddress();
        ipClient = ia.getHostAddress();
        System.out.println();
    }
}
