import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class E2 extends JFrame {
    Container cp;
    //JButton b;
    JLabel l;

    void init() {
        cp = getContentPane();
        //b = new JButton(new ImageIcon("imgs/p_girl.png"));
        l = new JLabel(new ImageIcon("imgs/p_girl.png"));
        cp.add(l);

        setUI();
    }

    void setUI() {
		setTitle("Layout Test");
		setSize(400, 300);
		setVisible(true);
		setLocation(200, 100);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new E2().init();
    }
}
