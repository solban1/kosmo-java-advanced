import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChatUI extends JFrame {
    JPanel topPanel, bottomPanel;
    JLabel myId;

    private void init() {
        initListeners();

        initUI();
        setUI();
    }

    void initUI() {
        label 
    }
    
    private void setUI() {
        setTitle("Text Editor (Warning: UTF-8 only)");
        setSize(800, 600);
        setVisible(true);
        // setLocation(200, 100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ChatUI().init();
    }
}
