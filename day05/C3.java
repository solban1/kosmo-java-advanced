import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class C3 extends JFrame {
    static final int ROWS = 4;
    static final int COLS = 5;
    
    Container cp;
    JButton bs[] = new JButton[ROWS * COLS];

    void init() {
        cp = getContentPane();
        cp.setLayout(new GridLayout(ROWS, COLS));
        ActionListener listener = e -> {
            System.out.println(e.getSource().hashCode());
        };

        for (JButton b : bs) {
            b = new JButton("b");
            b.addActionListener(listener);
            cp.add(b);
        } 

        setUI();
    }

    void setUI(){
		setTitle("GridLayout Test");
		setSize(400, 300);
		setVisible(true);
		setLocation(200, 100);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args) {
        new C3().init();
    }
}
