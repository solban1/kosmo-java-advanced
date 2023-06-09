import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

class U2Client {
    DatagramSocket ds;
    DatagramPacket dp;
    String ip;
    InetAddress ia;
    int port = 6000;
    BufferedReader br;

    U2Client() {
        br = new BufferedReader(new InputStreamReader(System.in));
        init();
    }

    void init() {
        inputIp();
        try {
            ds = new DatagramSocket();
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String msg;
        try {
            msg = br.readLine().strip();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        byte bs[] = msg.getBytes();
        dp = new DatagramPacket(bs, bs.length, ia, port);
        try {
            ds.send(dp);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void inputIp() {
        System.out.print("IP: ");
        String ip;
        try {
            ip = br.readLine().strip();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        if (ip.length() == 0) {
            ip = "127.0.0.1";
        }
        try {
            ia = InetAddress.getByName(ip);
        } catch (UnknownHostException e) {
            System.err.println("Unknown host");
        }
    }

    public static void main(String[] args) {
        new U2Client();
    }
}
