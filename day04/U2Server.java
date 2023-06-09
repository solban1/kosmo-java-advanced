import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

class U2Server {
    DatagramSocket ds;
    DatagramPacket dp;
    int port = 6000;

    U2Server() {
        try {
            ds = new DatagramSocket(port);
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("UDP Port " + port);

        byte[] bs = new byte[2048];
        dp = new DatagramPacket(bs, 2048);
        try {
            while (true) {
                ds.receive(dp);
                System.out.println("Client: " + new String(bs).strip());
                for (int i = 0; i < bs.length; i++) {
                    if (bs[i] == 0) break;
                    bs[i] = 0;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new U2Server();
    }
}
