import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class A3 {
    public static void main(String[] args) {
        PrintWriter pw;
        try {
            pw = new PrintWriter("keyboard.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        } finally {
        }
        pw.println("test");
        pw.flush();
        pw.close();
    }
}
