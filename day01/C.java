import java.io.*;

class C 
{
	String fname = "../�ڷ��/IO.jpg";
	FileInputStream fis; //���
	FileOutputStream fos; //��� 
	BufferedInputStream bis; //���� 
	BufferedOutputStream bos; //����
	C(){
		try{
			fis = new FileInputStream(fname);
			bis = new BufferedInputStream(fis, 1024); //����īƮ
			fos = new FileOutputStream("IO(copy).jpg");
			bos = new BufferedOutputStream(fos, 1024); //����īƮ
		}catch(FileNotFoundException fe){
		}
	}
	void rw(){ 
		byte bs[] = new byte[128]; //�����
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
