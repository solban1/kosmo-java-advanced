//File -> Monitor 
import java.io.*;

class D 
{
	String fname = "../../Java/수스자바.java";
	FileReader fr; //입력 
	PrintStream ps = System.out;//출력 
	OutputStreamWriter osw;
	
	D(){
		try{
			fr = new FileReader(fname);
			osw = new OutputStreamWriter(ps);
		}catch(FileNotFoundException fe){
		}
	}
	void rw(){
		char[] cs = new char[128]; //계란판
		try{
			while(true){
				int i = fr.read(cs);
				if(i == -1) break;
				osw.write(cs, 0, i);
			}
			osw.flush();
		}catch(IOException ie){
		}finally{
			try{
				fr.close();
				osw.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) {
		D d = new D();
		d.rw();
	}
}
