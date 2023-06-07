import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class A2Client {
    static final String SERVER_ADDRESS = "127.0.0.1";
    static final int SERVER_PORT = 4000;
    Socket s;
    DataOutputStream dos;

    A2Client() {
        try {
            s = new Socket(SERVER_ADDRESS, SERVER_PORT);
            dos = new DataOutputStream(s.getOutputStream());
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Success");



    }

    void speak() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        System.out.print("> ");
        try {
            line = br.readLine();
            dos.writeUTF(line);
            dos.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NullPointerException e) {
            try {
                dos.close();
                br.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.speak();
    }
}