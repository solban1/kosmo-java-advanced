import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    static final String SERVER_ADDRESS = "127.0.0.1";
    static final int SERVER_PORT = 4000;
    Socket s;

    ChatClient() {
        try {
            s = new Socket(SERVER_ADDRESS, SERVER_PORT);
        } catch (IOException e) {
            System.err.println("연결 실패: " + e);
            System.exit(-1);
        } 

        System.out.println(SERVER_ADDRESS + " 연결 성공");
        new Chat(s);
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}