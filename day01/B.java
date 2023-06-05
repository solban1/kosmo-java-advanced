//파일 -> 파일 
import java.io.*;

class B 
{	
	//String fname = "C:/SOO/행정/D강의실_230515.xlsx";
	String fname = "../자료실/IO.jpg";
	InputStream fis; 
	OutputStream fos;
	B(){
		try{
			fis = new FileInputStream(fname);
			//fos = new FileOutputStream("D강의실_230515(copy).xlsx");
			fos = new FileOutputStream("IO(copy).jpg");
		}catch(FileNotFoundException fe){
		}
	}
	void rw1(){ //read(), write(b)
		try{
			while(true){
				int b = fis.read(); //계란을 1개씩 
				if(b == -1) break;
				fos.write(b);
			}
			fos.flush();
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	void rw2(){ //read(byte[] b), write(byte[] b, int off, int len)
		byte bs[] = new byte[128]; //계란판
		try{
			int i = 0; 
			while((i= fis.read(bs)) != -1){
				fos.write(bs, 0, i);
			}
			fos.flush();
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args){
		B b = new B(); 
		//b.rw1();
		b.rw2();
	}
}
