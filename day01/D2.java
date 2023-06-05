import java.io.*;
import java.nio.charset.Charset;

public class D2 {
    String fname = "A.java";
    FileReader fr;
    PrintStream stdout = System.out;
    PrintWriter pw;
    // OutputStreamWriter osw;

    D2() {
        try {
            fr = new FileReader(fname, Charset.forName("UTF-8"));
            pw = new PrintWriter(stdout);
            // osw = new OutputStreamWriter(stdout);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void rw() {
        char[] cs = new char[16];
        int len;
        try {
            len = fr.read(cs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pw.write(cs, 0, len);
    }
}
