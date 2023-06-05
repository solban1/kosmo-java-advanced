import java.io.*;

class F {
	String path = "C:/SOO/Advanced/day01";
	File f1, f2, f3, f4, f5;
	F(){
		f1 = new File(path);
		f2 = new File("fTest.txt");
		f3 = new File("aa/bb/cc");
		f4 = new File("F.java");
		f5 = new File("A.class");
	}
	void m1(){ //exists()
		if(f1.exists()){
			pln("존재");
		}else{
			pln("존재하지 않음");
		}
	}
	void m2(){ //isFile()
		if(f1.isFile()){
			pln("파일");
		}else{
			pln("디렉토리");
		}
	}
	void m3() { //createNewFile()
		try{
			f2.createNewFile();
		}catch(IOException ie){}
	}
	void m4(){ //mkdir(), mkdirs()
		f3.mkdirs();
	}
	void m5(){//length()
		long size = f4.length();
		pln("size: " + size);
	}
	void m6(){ //delete()
		if(f5.exists()){
			f5.delete();
		}
	}
	void m7(){ //list(), listFiles()
		File[] kids = f1.listFiles();
		for(File kid : kids){
			pln(kid.getName() + " ("+kid.length()+"bytes)");
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		F obj = new F();
		//obj.m1(); obj.m2(); obj.m3(); 
		//obj.m4();
		//obj.m5();
		//obj.m6();
		obj.m7();
	}
}
