import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class C2 extends JFrame {
    Container cp;
    JButton[] buttons = new JButton[6];

    void init() {
        setLayout(new GridLayout(2, 3));
        cp = getContentPane();
        ActionListener listener = new C2Handler();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("buttons[" + i + "]");
            buttons[i].addActionListener(listener);
            cp.add(buttons[i]);
        }

        setUI();
    }

    void setUI() {
        setSize(400, 300);
        setLocation(800, 400);
        setTitle("title test");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class C2Handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();

            if (b == buttons[0]) {

            }
        }
    }

    public static void main(String[] args) {
        new C2().init();
    }    
}
