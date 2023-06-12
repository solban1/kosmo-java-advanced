import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Image 
class E extends JFrame {
	Container cp;
	//JButton b;
	JLabel laImg;
	ImageIcon ii;

	void init(){
		cp = getContentPane();

		//ii = new ImageIcon(getClass().getResource("imgs/puppy.gif"));
		ii = new ImageIcon(getClass().getResource("imgs/move.gif"));
		//b = new JButton(ii);
		laImg = new JLabel(ii);

		//cp.add(b);
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
		E e = new E();
		e.init();
	}
}
