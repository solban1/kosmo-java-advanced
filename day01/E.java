//File -> File
import java.io.*;

class E {
	FileReader fr; //노드 
	BufferedReader br; //필터 
	FileWriter fw; //노드 
	PrintWriter pw; //필터 
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
				//System.out.println(line); //모니터 출력
				pw.println(line); //파일(E.txt)에 출력 
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
