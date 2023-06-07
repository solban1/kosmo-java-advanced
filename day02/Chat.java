import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Chat {
    private Socket s;
    private DataOutputStream dos;
    private DataInputStream dis;
    private BufferedReader br;
    private String targetAddress;
    
    Chat(Socket s) {
        this.s = s;
        targetAddress = s.getInetAddress().getHostAddress();
        new Thread(() -> listen()).start();
        speak();
    }

    void speak() {
        br = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        try {
            dos = new DataOutputStream(s.getOutputStream());
            while (true) {
                System.out.print("> ");
                msg = br.readLine();
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException ie) {
            System.err.println(ie);
        } catch (NullPointerException ne) { // Ctrl+C
            System.out.println();
            System.out.println("채팅을 종료합니다.");
            System.exit(0);
        } finally {
            try {
                dos.close();
                br.close();
            } catch (IOException ie) {
                System.err.println("소켓 닫기 실패: " + ie);
            }
        }
    }

    void listen() {
        String msg = null;
        try {
            dis = new DataInputStream(s.getInputStream());
            while (true) {
                msg = dis.readUTF();
                System.out.println();
                System.out.println(targetAddress + ">> " + msg);
                System.out.print("> ");
            }
        } catch (IOException ie) {
            System.err.println("연결이 끊겼습니다. 채팅을 종료합니다.");
            System.exit(-1);
        } finally {
            try {
                dis.close();
            } catch (IOException ie) {
                System.err.println("소켓 닫기 실패: " + ie);
            }
        }
    }
}
