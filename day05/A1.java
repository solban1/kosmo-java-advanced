import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A1 extends JFrame 
{
	JButton b;
	void init(){
		b = new JButton("�ڹ��� ��ư");
		b.addActionListener(new A1Handler()); //(1)������Ŭ����
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
	class A1Handler implements ActionListener { //(1)������Ŭ����
		@Override
		public void actionPerformed(ActionEvent e){
			b.setText("Ŭ����! by ������Ŭ����");
		}
	}
}
