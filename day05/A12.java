import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class A12 extends JFrame {
    JButton b;

    void init() {
        b = new JButton("button");
        // ActionListener listener = new A12Handler();
        // b.addActionListener(listener);
        b.addActionListener(e -> System.out.println("clicked")); // 무명내부클래스
        b.addActionListener(e -> b.setText("clicked"));
        add(b);
        setUI();

    }

    void setUI() {
        setSize(300, 200);
        setLocation(800, 400);
        setTitle("title test");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class A12Handler implements ActionListener { // 유명내부클래스
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("clicked");
        }
    }

    public static void main(String[] args) {
        new A22().init();
    }
}