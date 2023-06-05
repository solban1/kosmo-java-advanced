import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class FileManager {
    private static void handleInputException(Reader r, IOException e) {
        System.err.println("키보드 입력을 받는 중 오류: " + e);
        try {
            r.close();
        } catch (IOException ie) {
            System.err.println("키보드 입력을 닫는 중 오류: " + ie);
        } finally {
            System.exit(-1);
        }
    }

    private static String getUserInput() {
        // BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        StdinReader stdin = new StdinReader();
        String input;

        System.out.print("> ");
        try {
            input = stdin.readLine();
        } catch (IOException e) {
            handleInputException(stdin, e);
            input = null;
        }
        return input;
    }

    private static void copy(File inFile, File outFile) {
        // BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(src));
        // BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(dest));
        BufferedFileInputStream inStream;
        BufferedFileOutputStream outStream;
        try {
            inStream = new BufferedFileInputStream(inFile);
            outStream = new BufferedFileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(-1);
            return;
        }
        
        byte[] bs = new byte[256];
        int len;
        try {
            while ((len = inStream.read(bs)) != -1) {
                outStream.write(bs, 0, len);
            }
        } catch (IOException e) {
            System.err.println("파일 작업 중 오류: " + e);
            System.exit(-1);
        } finally {
            try {
                inStream.close();
                outStream.close();
            } catch (IOException e) {
                System.err.println("스트림 닫는 중 오류: " + e);
            }
        }
    }

    public static void main(String[] args) {
        String task = null;
        System.out.println("1. 복사    2. 잘라내기");
        while (true) {
            String input = getUserInput().strip();
            switch (input) {
                case "1":
                    task = "복사";
                    break;
                case "2":
                    task = "잘라내기";
                    break;
            }
            if (task == null) {
                System.out.println("1 또는 2를 입력하세요.");
                continue;
            }
            break;
        }

        File inFile;
        System.out.println(task + "할 파일의 경로를 입력하세요.");
        while (true) {
            String input = getUserInput().strip();

            inFile = new File(input);
            if (!(inFile.exists())) {
                System.out.println("해당 경로가 존재하지 않습니다.");
                continue;
            }
            if (!(inFile.isFile())) {
                System.out.println("디렉토리가 아닌 파일을 지정해 주세요.");
                continue;
            }
            break;
        }

        File outDir;
        System.out.println("붙여넣을 디렉토리 경로를 입력해주세요.");
        while (true) {
            String input = getUserInput().strip();
            
            outDir = new File(input);
            if (!(outDir.exists())) {
                System.out.println("해당 경로가 존재하지 않습니다.");
                continue;
            }
            if (outDir.isFile()) {
                System.out.println("파일이 아닌 디렉토리를 지정해 주세요.");
                continue;
            }
            break;
        }

        File outFile = new File(outDir.getPath() + "/" + inFile.getName());

        try {
            if (inFile.getCanonicalPath().equals(outFile.getCanonicalPath())) {
                System.out.println(task + "할 파일과 같은 디렉토리에 붙여넣기할 수 없습니다.");
                return;
            } else if (outFile.isDirectory()) {
                System.out.println("붙여넣기할 위치에 같은 이름의 디렉토리가 존재하여 붙여넣을 수 없습니다.");
                return;
            } else if (outFile.isFile()) {
                System.out.println("붙여넣기할 위치에 같은 이름의 파일이 존재합니다.");
                System.out.println("덮어쓰시겠습니까? (Y/[N])");
                String input = getUserInput().strip().toLowerCase();
                if (!(input.equals("y"))) {
                    System.out.println("작업을 중단합니다.");
                    return;
                }
            }
        } catch (IOException e) {}

        copy(inFile, outFile);

        if (task == "잘라내기") {
            inFile.delete();
        }

        System.out.println(task + " 완료");
    }
}
