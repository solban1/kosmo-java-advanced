import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class FirstUI extends JFrame {
    Container cp;
    ImageIcon[] icons = new ImageIcon[4];

    JButton[] borderButtons = new JButton[4];
    String[] positions = { BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.WEST, BorderLayout.EAST };
    String[] borderTexts = { "북", "남", "서", "동" };
    ActionListener[] listeners = new ActionListener[4];

    JPanel p;
    JButton[] gridButtons = new JButton[4];

    FirstUI() {
        initListeners();
        initUI();

        setUI();
    }

    void initListeners() {
        listeners[0] = e -> {
            JOptionPane.showMessageDialog(null, icons[0], "메시지", JOptionPane.INFORMATION_MESSAGE);
        };

        listeners[1] = e -> {
            String[] options = { "Good", "Bad", "Normal" };
            String selection = (String) JOptionPane.showInputDialog(null, "오늘 기분 어때?", "질문", JOptionPane.PLAIN_MESSAGE,
                    icons[1], options, "Good");

            if (selection == null) {
                return;
            }
            String response = null;
            switch (selection) {
                case "Good":
                    response = "좋아";
                    break;

                case "Bad":
                    response = "싫어";
                    break;

                case "Normal":
                    response = "그냥 그래";
                    break;
            }
            JOptionPane.showMessageDialog(null, response, "답변", JOptionPane.PLAIN_MESSAGE);
        };

        listeners[2] = e -> {
            int selection = JOptionPane.showConfirmDialog(null, "종료할까요?", "선택", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE, icons[2]);
            if (selection == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        };

        listeners[3] = e -> {
            JOptionPane.showMessageDialog(null, "메세지 내용", "제목", JOptionPane.PLAIN_MESSAGE, icons[3]);
        };
    }

    void initUI() {
        cp = getContentPane();
        p = new JPanel(new GridLayout(2, 2));

        for (int i = 0; i < gridButtons.length; i++) {
            icons[i] = new ImageIcon("imgs/p" + (i + 1) + ".png");
            gridButtons[i] = new JButton(icons[i]);
            p.add(gridButtons[i]);
        }

        cp.add(p);

        for (int i = 0; i < borderButtons.length; i++) {
            borderButtons[i] = new JButton(borderTexts[i]);
            borderButtons[i].addActionListener(listeners[i]);
            cp.add(borderButtons[i], positions[i]);
        }
    }

    void setUI() {
        setTitle("JOptionPane Test");
        // setSize(400, 300);
        pack();
        setVisible(true);
        setLocation(200, 100);

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FirstUI();
    }
}
