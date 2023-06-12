import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A2 extends JFrame 
{
	JButton b;
	void init(){
		b = new JButton("자바의 버튼");

		/*ActionListener listener = new ActionListener(){ //(2)무명내부클래스
			@Override
			public void actionPerformed(ActionEvent e){
				b.setText("클릭됨! by 무명내부클래스");
			}
		};
		b.addActionListener(listener);*/
		/*b.addActionListener(new ActionListener(){ //(2)무명내부클래스
			@Override
			public void actionPerformed(ActionEvent e){
				b.setText("클릭됨! by 무명내부클래스");
			}
		});*/
		/*ActionListener listener = (e) -> b.setText("클릭됨! by 무명내부클래스[람다식1]"); //(2)무명내부클래스
		b.addActionListener(listener);*/
		b.addActionListener((e) -> b.setText("클릭됨! by 무명내부클래스[람다식2]")); //(2)무명내부클래스
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
