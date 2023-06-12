import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A3 extends JFrame 
{
	JButton b;
	void init(){
		b = new JButton("자바의 버튼");
		add(b);

		b.addActionListener(new A3Handler(this)); //(3)제3클래스
		
		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");
		setSize(300, 200);
		setVisible(true);
		setLocation(200, 100);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		A3 a3 = new A3();
		a3.init();
	}
}
