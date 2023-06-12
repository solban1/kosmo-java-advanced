import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A1 extends JFrame 
{
	JButton b;
	void init(){
		b = new JButton("자바의 버튼");
		b.addActionListener(new A1Handler()); //(1)유명내부클래스
		add(b);

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
		A1 a1 = new A1();
		a1.init();
	}
	class A1Handler implements ActionListener { //(1)유명내부클래스
		@Override
		public void actionPerformed(ActionEvent e){
			b.setText("클릭됨! by 유명내부클래스");
		}
	}
}
