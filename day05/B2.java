import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class B2 extends JFrame implements ActionListener {
    Container cp;
    JButton bN, bS, bW, bE;

    JPanel p;
    JButton bPC, bPE, bPW;

    void init() {
        bN = new JButton("N");
        bS = new JButton("S");
        bW = new JButton("W");
        bE = new JButton("E");

        p = new JPanel(new BorderLayout());
        bPC = new JButton("PCenter");
        bPE = new JButton("PE");
        bPW = new JButton("PW");

        p.add(bPC);
        p.add(bPE, BorderLayout.EAST);
        p.add(bPW, BorderLayout.WEST);
        

        cp = getContentPane();
        cp.add(bN, BorderLayout.NORTH);
        cp.add(bW, BorderLayout.WEST);
        cp.add(bS, BorderLayout.SOUTH);
        cp.add(bE, BorderLayout.EAST);
        cp.add(p);

        for (JButton b : Set.of(bN, bS, bW, bE, bPC, bPE, bPW)) {
            b.addActionListener(this);
        }

        setUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        if (b == bN) {
            
        }
    }

    void setUI() {
        setSize(400, 300);
        setLocation(800, 400);
        setTitle("title test");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new B2().init();
    }
}
