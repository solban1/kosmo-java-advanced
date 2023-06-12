import javax.swing.JButton;
import javax.swing.JFrame;

public class A14 extends JFrame {
    void init() {
        JButton b = new JButton("localTest");
        b.addActionListener(e -> b.setText("changed"));
        add(b);

        setUI();
    }

    void setUI() {
        setTitle("GUI");
        setSize(300, 200);
        setVisible(true);
        setLocation(300, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new A14().init();
    }
}
