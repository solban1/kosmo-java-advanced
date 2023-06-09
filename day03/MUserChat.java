import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MUserChat {
    private User user;
    MUserChat(Socket s, String name) throws IOException {
        user = new User(s, name);
        new Thread(() -> listen()).start();
        speak();
    }

    void listen() {
        String msg = null;
        try {
            while (true) {
                msg = user.recvMessage();
                System.out.print("\33[2K\r");
                System.out.println(msg);
                System.out.print("> ");
            }
        } catch (IOException ie) {
            System.out.print("\33[2K\r");
            System.err.println("서버와의 연결이 끊겼습니다. 채팅을 종료합니다.");
            System.exit(-1);
        } finally {
            try {
                user.close();
            } catch (IOException ie) {
                System.err.println("소켓 닫기 실패: " + ie);
            }
        }
    }

    void speak() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        try {
            while (true) {
                System.out.print("> ");
                msg = br.readLine();
                user.sendMessage(msg);
            }
        } catch (IOException ie) {
            System.err.println(ie);
        } catch (NullPointerException ne) { // Ctrl+C
            System.out.print("\33[2K\r");
            System.out.println("채팅을 종료합니다.");
            System.exit(0);
        } finally {
            try {
                user.close();
            } catch (IOException ie) {
                System.err.println("소켓 닫기 실패: " + ie);
            }
        }
    }
}
