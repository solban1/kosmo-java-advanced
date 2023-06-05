import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StdinReader extends BufferedReader {
    StdinReader() {
        super(new InputStreamReader(System.in));
    }
}