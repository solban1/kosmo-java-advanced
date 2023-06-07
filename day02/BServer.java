import java.net.*;
import java.io.*;

class BServer{
	int port = 4000;
	ServerSocket ss;
	Socket s;
	String ipClient;

	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;
	BServer(){
		try{
			ss = new ServerSocket(port);
			pln(port+"번 포트에서 TCP서버 대기중..");
			//while(true){
			s = ss.accept();
			InetAddress ia = s.getInetAddress();
			ipClient = ia.getHostAddress();
			pln("클라이언트("+ipClient+") 접속완료!!");
				//s.close();
			//}
			
			is = s.getInputStream();
			dis = new DataInputStream(is);
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			
			//Runnable r = () -> listen();
			//new Thread(r).start();
			new Thread(() -> listen()).start();

			speak();
		}catch(IOException ie){
			pln(port+"번 포트는 이미 사용중입니다");
		}finally{
			try{
				s.close();
				ss.close();
			}catch(IOException ie){}
		}
	}
	void listen(){ //Socket -> Monitor 
		String msg = "";
		try{
			while(true){
				msg = dis.readUTF();
				pln("Client>> " + msg);
			}
		}catch(IOException ie){
			pln("클라이언트 퇴장! 2초후에 프로그램을 종료할께요~");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException iie){}
			System.exit(-1);
		}finally{
			try{
				dis.close();
				is.close();
			}catch(IOException ie){}
		}
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void speak(){ //Keyboard -> Socket 
		String line = "";
		try{
			while(true){
				line = br.readLine();
				dos.writeUTF(line);
				dos.flush();
			}
		}catch(IOException ie){
		}finally{
			try{
				dos.close();
				os.close();
				br.close();
			}catch(IOException ie){}
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		BServer server = new BServer();
	}
}
