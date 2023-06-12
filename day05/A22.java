import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class A22 extends JFrame implements ActionListener {
    JButton b;

    void init() {
        b = new JButton("button");
        //b.addActionListener(new A22Handler(this));
        b.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) { // 자신의 클래스에서 처리
        setTitle("title changed");
        b.setText("clicked");
    }

    public static void main(String[] args) {
        new A22().init();
    }
}

class A22Handler implements ActionListener { // 제3클래스
    JFrame f;

    A22Handler(JFrame f) {
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        b.setText("clicked");

        f.setTitle("title changed");
    }
}