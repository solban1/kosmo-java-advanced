import java.io.*;

public class C2 {
    String inName = "A.java";
    FileInputStream fis;
    FileOutputStream fos;
    BufferedInputStream bis;
    BufferedOutputStream bos;

    C2() {
        try {
            fis = new FileInputStream(inName);
            fos = new FileOutputStream("A_copy.java");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        bis = new BufferedInputStream(fis);
        bos = new BufferedOutputStream(fos);
    }

    void rw() {
        byte[] bs = new byte[16];
        int len;
        try {
            while((len = bis.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
            bos.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new C2().rw();
    }
}
