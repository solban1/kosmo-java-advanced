import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    static final int PORT = 4000;
    ServerSocket ss;
    Socket s;

    ChatServer() {
        try {
            ss = new ServerSocket(PORT);
            System.out.println(PORT + "번 포트에서 연결을 받는 중");
            s = ss.accept();
        } catch (IOException e) {
            System.err.println("연결 실패: " + e);
            System.exit(-1);
        }

        System.out.println(s.getInetAddress().getHostAddress() + " 연결됨");
        new Chat(s);
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}