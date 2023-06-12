import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//CardLayout
class D extends JFrame implements ActionListener {
	Container cp;
	String labels[] = {"��L", "��", "��", "��", "��", "��", "��", "��H"};
	JButton bs[];

	void init(){
		setLayout(new CardLayout());
		cp = getContentPane();
		bs = new JButton[8];

		undo();

		setUI();
	}
	void undo(){
		for(int i=0; i<labels.length; i++){
			bs[i] = new JButton(labels[i]);
			bs[i].addActionListener(this);
			cp.add(bs[i]);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){ //ī�带 �ϳ��� �Ⱦ�����
		Object obj = e.getSource();
		JButton b = (JButton)obj;
		cp.remove(b);
		if(b == bs[bs.length-1]) undo();

		revalidate();
		//repaint();
	}
	void setUI(){
		setTitle("CardLayout Test");
		setSize(300, 300);
		setVisible(true);
		setLocation(200, 100);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		D d = new D();
		d.init();
	}
}
