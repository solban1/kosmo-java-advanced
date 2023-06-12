import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//GridLayout
class C extends JFrame {
	Container cp;
	JButton bs[] = new JButton[6]; 
	void init(){
		setLayout(new GridLayout(2,3));
		cp = getContentPane();
		ActionListener listener = new CHandler(this);
		for(int i=0; i<bs.length; i++){
			bs[i] = new JButton("��ư "+(i+1));
			bs[i].addActionListener(listener);
			cp.add(bs[i]);
		}

		setUI();
	}
	void setUI(){
		setTitle("GridLayout Test");
		setSize(400, 300);
		setVisible(true);
		setLocation(200, 100);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		C c = new C();
		c.init();
	}
}
class CHandler implements ActionListener {
	C c;
	CHandler(C c){
		this.c = c;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();
		if(b == c.bs[0]){
			System.out.println("ù��°");
			c.bs[0].setText("ù��°");
		}else if(b == c.bs[1]){
			System.out.println("�ι�°");
		}else if(b == c.bs[2]){
			System.out.println("����°");
		}else if(b == c.bs[3]){
			System.out.println("�׹�°");
		}else if(b == c.bs[4]){
			System.out.println("�ټ���°");
		}else {
			System.out.println("������°");
		}
	}
}
