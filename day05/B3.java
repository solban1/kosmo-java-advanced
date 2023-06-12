import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class B3 extends JFrame {
    Container cp;
    JPanel p;
    JButton bN, bS, bW, bE, bC, bPC, bPE, bPW;

    void init() {
        cp = getContentPane();
        p = new JPanel(new CardLayout(20, 20));
        ActionListener listener = e -> {
            JButton bb = (JButton) e.getSource();
            bb.setText(String.valueOf(bb.getLocation().getX()));
        };

        for (JButton b : Arrays.asList(bN, bS, bW, bE, bC)) { // doesn't allow null
            b = new JButton("b");
            b.addActionListener(listener);
            cp.add(b);
        }

        cp.add(p);

        for (JButton b : Arrays.asList(bPC, bPE, bPW)) {
            b = new JButton("pb");
            b.addActionListener(listener);
            p.add(b);
        }

        setUI();
    }

    void setUI(){
        setLayout(new FlowLayout());
		setTitle("Test");
		setSize(400, 300);
		setVisible(true);
		setLocation(200, 100);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


    public static void main(String[] args) {
        new B3().init();
    }
}
