import java.io.*;

class A 
{
	/*BufferedReader brKey 
		= new BufferedReader(new InputStreamReader(System.in));*/
	InputStream is = System.in; //�Է½�Ʈ��(�ٺ�==���)
	InputStreamReader isr = new InputStreamReader(is); //�Է½�Ʈ��(�긴��)
	BufferedReader brKey = new BufferedReader(isr); //�Է½�Ʈ��(����==����==����) 

	PrintStream ps = System.out; //��½�Ʈ��1 
	String fname = "keyboard.txt";
	FileWriter fw; //��½�Ʈ��2(�ٺ�==���)
	PrintWriter pw; //��½�Ʈ��2(����==����==����)
	
	A(){
		try{
			fw = new FileWriter(fname);
			pw = new PrintWriter(fw, true); //���Ͽ� ���� 
		}catch(IOException ie){}
	}
	void rw(){
		try{
			String line = brKey.readLine();
			ps.println("line: " + line);
			pw.println(line);
			System.out.println(fname+"�� Ȯ���غ�����");
		}catch(IOException ie){
		}
	}
	public static void main(String[] args) 
	{
		new A().rw();
	}
}
