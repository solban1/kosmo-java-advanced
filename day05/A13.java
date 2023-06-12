import javax.swing.JButton;
import javax.swing.JFrame;

class A13 extends JFrame {
    JButton b;

    void init() {
        b = new JButton("test")
        b.addActionListener(e -> b.setText("changed"));
        add(b);

        setUI();
    }

    void setUI() {
        setTitle("GUI");
        setSize(300, 200);
        setVisible(true);
        setLocation(200, 100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new A13().init();
    }
}