import java.io.*;
import java.net.*;

class F2Server {
    ServerSocket ss;
    Socket s;
    int port = 3500;
    String ipClient;
    BufferedInputStream bis;
    FileOutputStream fos;
    BufferedOutputStream bos;
    String fName = "IO(copy).jpg";

    F2Server() {
        try {
            ss = new ServerSocket(port);
            System.out.println(port + "번 포트에서 파일서버 대기중");
            s = ss.accept();
            ipClient = s.getInetAddress().getHostAddress();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("클라이언트(" + ipClient + ") 연결 완료");
        makeStream();
        receive();
    }

    void makeStream() {
        File dir = new File("store");
        if (!dir.exists()) {
            dir.mkdir();
        }

        try {
            bis = new BufferedInputStream(s.getInputStream(), 2048);
            fos = new FileOutputStream(dir + "/" + fName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        bos = new BufferedOutputStream(fos, 2048);

    }

    void receive() {
        long totalSize = forward(bis, bos);
        try {
            bis.close();
            bos.close();
            fos.close();
            s.close();
            ss.close();
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
        new F2Server();
    }
}