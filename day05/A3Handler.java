import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A3Handler implements ActionListener { //(3)��3Ŭ����
	A3 a3;
	A3Handler(A3 a3){
		this.a3 = a3;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		//Object obj = e.getSource();
		//JButton b = (JButton)obj;
		a3.b.setText("Ŭ����! by ��3Ŭ����");
		a3.setTitle("����� ���� ������");
	}
}