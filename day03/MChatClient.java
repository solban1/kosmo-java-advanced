import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MChatClient {
    static final String SERVER_ADDRESS = "127.0.0.1";
    static final int SERVER_PORT = 4000;
    Socket s;
    String name;

    MChatClient() {
        System.out.print("이름: ");
        try {
            name = new BufferedReader(new InputStreamReader(System.in)).readLine().strip();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println();
            System.exit(-1);
        }

        if (name == null || name == "") {
            System.out.println("이름을 입력하지 않아 종료합니다.");
            System.exit(-1);
        }

        try {
            s = new Socket(SERVER_ADDRESS, SERVER_PORT);
        } catch (IOException e) {
            System.err.println("연결 실패");
            System.exit(-1);
        } 

        System.out.println(SERVER_ADDRESS + " 연결 성공");
        try {
            new MUserChat(s, name);
        } catch (IOException e) {
            System.err.println("종료합니다.");
        }
    }

    public static void main(String[] args) {
        new MChatClient();
    }
}