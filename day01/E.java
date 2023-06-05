//File -> File
import java.io.*;

class E {
	FileReader fr; //��� 
	BufferedReader br; //���� 
	FileWriter fw; //��� 
	PrintWriter pw; //���� 
	E(){
		try{
			fr = new FileReader("E.java");
			br = new BufferedReader(fr);
			fw = new FileWriter("E.txt");
			pw = new PrintWriter(fw, true);
		}catch(FileNotFoundException fe){
		}catch(IOException ie){}
	}
	void rw(){
		String line = "";
		try{
			while((line = br.readLine()) != null){
				//System.out.println(line); //����� ���
				pw.println(line); //����(E.txt)�� ��� 
			}
		}catch(IOException ie){
		}finally{
			try{
				br.close();
				pw.close();
				fr.close();
				fw.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) {
		E e = new E();
		e.rw();
	}
}
