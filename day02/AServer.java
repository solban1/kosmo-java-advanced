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
			pln(port+"�� ��Ʈ���� TCP���� �����..");
			//while(true){
			s = ss.accept();
			InetAddress ia = s.getInetAddress();
			ipClient = ia.getHostAddress();
			pln("Ŭ���̾�Ʈ("+ipClient+") ���ӿϷ�!!");
				//s.close();
			//}
			
			is = s.getInputStream();
			dis = new DataInputStream(is);

			listen();
		}catch(IOException ie){
			pln(port+"�� ��Ʈ�� �̹� ������Դϴ�");
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
