import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//BorderLayout
class B extends JFrame implements ActionListener {
	Container cp;
	JButton bN, bS, bW, bE, bC;

	JPanel p;
	JButton bPC, bPE, bPW;

	void init(){
		p = new JPanel();
		p.setLayout(new BorderLayout());
		bPC = new JButton("패-센터");
		bPE = new JButton("패-동");
		bPW = new JButton("패-서");
		p.add(bPC);
		p.add(bPE, BorderLayout.EAST);
		p.add(bPW, BorderLayout.WEST);

		bN = new JButton("북");  
		bS = new JButton("남"); 
		bW = new JButton("서"); 
		bE = new JButton("동"); 
		//bC = new JButton("센터"); 

		cp = getContentPane();
		cp.add(bN, BorderLayout.NORTH);
		cp.add(bS, BorderLayout.SOUTH);
		cp.add(bW, BorderLayout.WEST);
		cp.add(bE, BorderLayout.EAST);
		//cp.add(bC);
		cp.add(p);

		bN.addActionListener(this);
		bS.addActionListener(this);
		bW.addActionListener(this);
		bE.addActionListener(this);
		bPC.addActionListener(this);
		bPE.addActionListener(this);
		bPW.addActionListener(this);

		setUI();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();
		if(b == bN){
			System.out.println("점");
		}else if(b == bS){
			System.out.println("심");
		}else if(b == bW){
			System.out.println("시");
		}else if(b == bE){
			System.out.println("간");
		}else if(b == bPC){
			System.out.println("나");
		}else if(b == bPE){
			System.out.println("이");
		}else{
			System.out.println("스!");
		}

		setTitle("클릭 "+b.getText());
	}
	void setUI(){
		setTitle("BorderLayout Test");
		setSize(400, 300);
		setVisible(true);
		setLocation(200, 100);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		B b = new B();
		b.init();
	}
}
