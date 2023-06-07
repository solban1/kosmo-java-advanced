import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class B3Server {
    int port = 3333;
    ServerSocket ss;
    Socket s;
    String ipClient;

    InputStream is;
    DataInputStream dis;
    OutputStream os;
    DataOutputStream dos;

    B3Server() {
        try {
            ss = new ServerSocket(port);
            System.out.println(port + " waiting");
            s = ss.accept();
            InetAddress ia = s.getInetAddress();
            ipClient = ia.getHostAddress();
            System.out.println(ipClient + " connected");

            is = s.getInputStream();
            dis = new DataInputStream(is);
            os = s.getOutputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dos = new DataOutputStream(os);

        new Thread(() -> listen()).start();
        speak();
    }

    void listen() {
        String msg = "";
        while (true) {
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("exit");
                System.exit(-1);
            }
            System.out.println("Client>> " + msg);
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void speak() {
        String line = "";
        while (true) {
            try {
                line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        B3Server server = new B3Server();
    }
}
