import java.net.*;
import java.io.*;

class AServer {
	int port = 4000;
	ServerSocket ss;
	Socket s;
	String ipClient;

	InputStream is;
	DataInputStream dis;
	AServer(){
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

			listen();
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
		}finally{
			try{
				dis.close();
				is.close();
			}catch(IOException ie){}
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		AServer server = new AServer();
	}
}
