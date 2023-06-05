import java.io.*;

public class A2 {
    InputStream is = System.in;
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader brKey = new BufferedReader(isr);

    PrintStream ps = System.out;
    String fname = "keyboard.txt";
    File f;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;

    A2() {
        f = new File(fname);
        try {
            fw = new FileWriter(f);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw, true);
    }

    void r() {
        try {
            pw.println(brKey.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new A2().r();
    }

}