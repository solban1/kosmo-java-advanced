import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.HashMap;

class UServerClient {
    DatagramSocket ds;
    DatagramPacket dpIn;
    DatagramPacket dpOut;
    BufferedReader br;
    InetAddress ia;
    HashMap<String, String> ipName;
    HashMap<String, String> nameIp;

    static final String FILENAME = "ips.txt";
    int port = 6000;

    UServerClient() {
        try {
            ds = new DatagramSocket(port);
        } catch (SocketException e) {
            System.out.println(port + "번 포트가 이미 사용 중입니다.");
            System.exit(-1);
        }
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("UDP Port " + port);

        initList();
        new Thread(() -> listen()).start();
        inputIp();
        String ip = ia.getHostAddress();
        String name = ipName.get(ip);
        if (name == null) {
            System.out.println("메시지 보낼 주소: " + ip);
        } else {
            System.out.println("메시지 보낼 대상: " + name);
        }

        while (true) {
            sendMessage();
        }

    }

    void initList() {
        BufferedReader fbr = null;
        try {
            fbr = new BufferedReader(new FileReader(FILENAME, Charset.forName("UTF-8")));
        } catch (IOException fe) {
            System.err.println(FILENAME + " 파일을 찾을 수 없습니다.");
            System.exit(-1);
        }

        String line;
        ipName = new HashMap<>();
        nameIp = new HashMap<>();
        try {
            while ((line = fbr.readLine()) != null) {
                line = line.strip();
                int spaceIdx = line.indexOf(' ');
                String lineName = line.substring(0, spaceIdx).stripTrailing();
                String lineIp = line.substring(spaceIdx).stripLeading();

                ipName.put(lineIp, lineName);
                nameIp.put(lineName, lineIp);
            }
        } catch (IOException e1) {
            System.err.println("파일을 읽는 중 오류: " + e1);
            System.exit(-1);
        }
    }

    void listen() {
        byte[] bs = new byte[2048];
        dpIn = new DatagramPacket(bs, 2048);
        try {
            while (true) {
                ds.receive(dpIn);
                String ip = dpIn.getAddress().getHostAddress();
                String name = ipName.get(ip);
                System.out.println((name == null ? ip : name) + "> " + new String(bs).strip());
                for (int i = 0; i < bs.length; i++) {
                    if (bs[i] == 0)
                        break;
                    bs[i] = 0;
                }
            }
        } catch (IOException e) {
            System.err.println("패킷을 받는 중 오류: " + e);
            System.exit(-1);
        }
    }

    void inputIp() {
        System.out.print("IP 또는 이름(기본값: 127.0.0.1): ");
        String ip;
        try {
            ip = br.readLine().strip();
        } catch (IOException e) {
            System.err.println("IP를 입력받는 중 오류: " + e);
            System.exit(-1);
            return;
        } catch (NullPointerException e) {
            System.out.println();
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
            return;
        }

        if (ip.length() == 0) {
            ip = "127.0.0.1";
        }

        try {
            ia = InetAddress.getByName("192.168.0." + ip); // ip == number
        } catch (UnknownHostException e) { // ip == name or full ip
            try {
                ia = InetAddress.getByName(ip);
            } catch (UnknownHostException ue) { // ip == name
                try {
                    String name = nameIp.get(ip);
                    if (name == null) {
                        System.out.println(FILENAME + " 파일에서 " + ip + " 님을 찾을 수 없습니다.");
                        System.exit(-1);
                    }
                    ia = InetAddress.getByName(name);
                } catch (UnknownHostException uue) {
                    System.out.println(FILENAME + " 파일 중 " + ip + " 님의 IP 주소 형식이 잘못되었습니다.");
                    System.exit(-1);
                }
            }

        }
    }

    void sendMessage() {
        String msg;
        try {
            msg = br.readLine().strip();
        } catch (IOException e) {
            System.err.println("메시지 입력받는 중 오류: " + e);
            System.exit(-1);
            return;
        } catch (NullPointerException e) {
            System.out.println();
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
            return;
        }

        byte bs[] = msg.getBytes();
        dpOut = new DatagramPacket(bs, bs.length, ia, port);
        try {
            ds.send(dpOut);
        } catch (IOException e) {
            System.out.println("패킷을 보내는 중 오류: " + e);
        }
    }

    public static void main(String[] args) {
        new UServerClient();
    }
}