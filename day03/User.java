import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class User {
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    String name;

    User(Socket s) throws IOException { // server mode
        this.s = s;
        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());
        this.name = recvMessage();
    }

    User(Socket s, String name) throws IOException { // client mode
        this.s = s;
        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());
        this.name = name;
        sendMessage(name);
    }

    String recvMessage() throws IOException {
        return dis.readUTF();
    }

    void sendMessage(String msg) throws IOException {
        dos.writeUTF(msg);
        dos.flush();
    }

    void close() throws IOException {
        dis.close();
        dos.close();
        s.close();
    }
}
