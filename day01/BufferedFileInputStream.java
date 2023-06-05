import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BufferedFileInputStream extends BufferedInputStream {
    BufferedFileInputStream(String fileName) throws FileNotFoundException {
        super(new FileInputStream(fileName));
    }

    BufferedFileInputStream(File file) throws FileNotFoundException {
        super(new FileInputStream(file));
    }
}
