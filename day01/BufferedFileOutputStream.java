import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferedFileOutputStream extends BufferedOutputStream {
    BufferedFileOutputStream(String fileName) throws FileNotFoundException {
        super(new FileOutputStream(fileName));
    }

    BufferedFileOutputStream(File file) throws FileNotFoundException {
        super(new FileOutputStream(file));
    }
}
