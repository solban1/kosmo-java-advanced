import javax.swing.JButton;
import javax.swing.JFrame;

public class A15 {
    public static void main(String[] args) {
        JFrame f = new JFrame("mainTest");
        JButton b = new JButton("testButton");
        b.addActionListener(e -> System.out.println("It works"));
        // f.add(b);
        f.getContentPane().add(b);

        f.setSize(300, 200);
        f.setVisible(true);
        f.setLocation(300, 200);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
