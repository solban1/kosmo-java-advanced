import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A2 extends JFrame 
{
	JButton b;
	void init(){
		b = new JButton("�ڹ��� ��ư");

		/*ActionListener listener = new ActionListener(){ //(2)������Ŭ����
			@Override
			public void actionPerformed(ActionEvent e){
				b.setText("Ŭ����! by ������Ŭ����");
			}
		};
		b.addActionListener(listener);*/
		/*b.addActionListener(new ActionListener(){ //(2)������Ŭ����
			@Override
			public void actionPerformed(ActionEvent e){
				b.setText("Ŭ����! by ������Ŭ����");
			}
		});*/
		/*ActionListener listener = (e) -> b.setText("Ŭ����! by ������Ŭ����[���ٽ�1]"); //(2)������Ŭ����
		b.addActionListener(listener);*/
		b.addActionListener((e) -> b.setText("Ŭ����! by ������Ŭ����[���ٽ�2]")); //(2)������Ŭ����
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
		A2 a2 = new A2();
		a2.init();
	}
}
