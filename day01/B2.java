import java.io.*;

public class B2 {
    String inName = "A.java";
    String outName = "A_copy.java";
    FileInputStream fis;
    FileOutputStream fos;

    B2() {
        try {
            fis = new FileInputStream(inName);
            fos = new FileOutputStream(outName);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void rw() {
        byte bs[] = new byte[16];
        int len;
        try {
            while ((len = fis.read(bs)) != -1) {
                fos.write(bs, 0, len);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new B2().rw();
    }
}
