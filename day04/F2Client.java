import java.io.*;
import java.net.*;

class F2Client {
    Socket s;
    String ip = "127.0.0.1";
    int port = 3500;
    String path = "IO.jpg";
    BufferedInputStream bis;
    BufferedOutputStream bos;

    F2Client() {
        try {
            s = new Socket(ip, port);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        makeStream();
        send();

    }

    void makeStream() {
        try {
            bis = new BufferedInputStream(new FileInputStream(path), 2048);
            bos = new BufferedOutputStream(s.getOutputStream(), 2048);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    void send() {
        long totalSize = forward(bis, bos);
        try {
            bis.close();
            bos.close();
            s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    long forward(InputStream is, OutputStream os) {
        byte bs[] = new byte[512];
        int i = 0;
        long totalSize = 0L;
        try {
            while((i = bis.read(bs)) != -1) {
                bos.write(bs, 0, i);
                totalSize += i;
            }
            bos.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return totalSize;
    }

    public static void main(String[] args) {
        new F2Client();
    }
}
