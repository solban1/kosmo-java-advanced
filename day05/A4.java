import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A4 extends JFrame implements ActionListener
{
	JButton b;
	void init(){
		b = new JButton("자바의 버튼");
		add(b);
		b.addActionListener(this); //(4)자신의클래스
		
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
	@Override
	public void actionPerformed(ActionEvent e){
		b.setText("클릭됨! by 자신의클래스");
	}
	public static void main(String[] args) 
	{
		A4 a4 = new A4();
		a4.init();
	}
}