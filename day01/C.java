import java.io.*;

class C 
{
	String fname = "../자료실/IO.jpg";
	FileInputStream fis; //노드
	FileOutputStream fos; //노드 
	BufferedInputStream bis; //필터 
	BufferedOutputStream bos; //필터
	C(){
		try{
			fis = new FileInputStream(fname);
			bis = new BufferedInputStream(fis, 1024); //쇼핑카트
			fos = new FileOutputStream("IO(copy).jpg");
			bos = new BufferedOutputStream(fos, 1024); //쇼핑카트
		}catch(FileNotFoundException fe){
		}
	}
	void rw(){ 
		byte bs[] = new byte[128]; //계란판
		try{
			int i = 0; 
			while((i= bis.read(bs)) != -1){
				bos.write(bs, 0, i);
			}
			bos.flush();
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) 
	{
		C c = new C();
		c.rw();
	}
}
