import java.io.*;

class A 
{
	/*BufferedReader brKey 
		= new BufferedReader(new InputStreamReader(System.in));*/
	InputStream is = System.in; //입력스트림(근본==노드)
	InputStreamReader isr = new InputStreamReader(is); //입력스트림(브릿지)
	BufferedReader brKey = new BufferedReader(isr); //입력스트림(필터==응용==목적) 

	PrintStream ps = System.out; //출력스트림1 
	String fname = "keyboard.txt";
	FileWriter fw; //출력스트림2(근본==노드)
	PrintWriter pw; //출력스트림2(필터==응용==목적)
	
	A(){
		try{
			fw = new FileWriter(fname);
			pw = new PrintWriter(fw, true); //파일에 쓰기 
		}catch(IOException ie){}
	}
	void rw(){
		try{
			String line = brKey.readLine();
			ps.println("line: " + line);
			pw.println(line);
			System.out.println(fname+"을 확인해보세요");
		}catch(IOException ie){
		}
	}
	public static void main(String[] args) 
	{
		new A().rw();
	}
}
