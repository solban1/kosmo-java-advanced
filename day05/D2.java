import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class D2 extends JFrame {
    Container cp;
    String[] labels = {"C", "D", "E", "F", "G", "A", "B", "C+"};
    JButton bs[] = new JButton[8];

    void init() {
        cp = getContentPane();
        setLayout(new CardLayout());

        

        addButtons();

        setUI();
    }

    void addButtons() {
        ActionListener listener = e -> {
            JButton b = (JButton)e.getSource();
            cp.remove(b);
            if (b == bs[bs.length - 1]) {
                addButtons();
            }

            cp.validate();
        };

        for (int i = 0; i < bs.length; i++) {
            bs[i] = new JButton(labels[i]);
            bs[i].addActionListener(listener);
            cp.add(bs[i]);
        }
    }

    void setUI(){
		setTitle("Layout Test");
		setSize(400, 300);
		setVisible(true);
		setLocation(200, 100);

		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args) {
        new D2().init();
    }
}
