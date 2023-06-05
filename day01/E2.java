import java.io.*;

public class E2 {
    FileReader fr;
    BufferedReader br;
    PrintWriter pw;

    E2() {
        try {
            fr = new FileReader("A.java");
            pw = new PrintWriter("A_copy.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        br = new BufferedReader(fr);
    }
    void rw() {
        String line;
        try {
            while((line = br.readLine()) != null) {
                pw.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pw.flush();
    }

    public static void main(String[] args) {
        new E2().rw();
    }
}
