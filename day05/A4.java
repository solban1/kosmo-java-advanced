import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A4 extends JFrame implements ActionListener
{
	JButton b;
	void init(){
		b = new JButton("�ڹ��� ��ư");
		add(b);
		b.addActionListener(this); //(4)�ڽ���Ŭ����
		
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
		b.setText("Ŭ����! by �ڽ���Ŭ����");
	}
	public static void main(String[] args) 
	{
		A4 a4 = new A4();
		a4.init();
	}
}