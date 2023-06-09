import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MChatServer {
    static final int PORT = 4000;
    ServerSocket ss;
    Socket s;

    MChatServer() {
        try {
            ss = new ServerSocket(PORT);
            MAdminChat adminChat = new MAdminChat();
            System.out.println(PORT + "번 포트에서 연결을 받는 중");
            while (true) {
                s = ss.accept();
                adminChat.addUser(s);
            }
        } catch (IOException e) {
            System.err.println("연결 실패: " + e);
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new MChatServer();
    }
}