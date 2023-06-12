import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class E3 extends JFrame {
    Container cp;
    JLabel laImg;
    ImageIcon ii;

    void init() {
        cp = getContentPane();

        ii = new ImageIcon("imgs/p1.gif");
        laImg = new JLabel(ii);

        cp.add(laImg);

        setUI();
    }

    void setUI(){
		setTitle("Image Test");
		pack();
		setVisible(true);
		setLocation(200, 100);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args) {
        new E3().init();
    }
    
}
