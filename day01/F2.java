import java.io.*;

public class F2 {
    String path = "D:\\Sol\\Java\\kosmo-java-advanced\\day01\\A.java";
    String path2 = ".";
    File f;
    File f2;

    F2() {
        // f = new File(path);
        // if (f.exists()) {
        //     System.out.println("Success");
        // } else {
        //     System.out.println("Failure");
        // }
        // if (f.isFile()) {
        //     System.out.println("File");
        // } else {
        //     System.out.println("Not file");
        // }
        // if (f.isDirectory()) {
        //     System.out.println("Directory");
        // } else {
        //     System.out.println("Not Directory");
        // }

        for (File s : new File(path2).listFiles()) {
            System.out.println(s.getPath() + " " + s.length());
        }


    }

    public static void main(String[] args) {
        new F2();
    }
}
