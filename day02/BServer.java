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
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			
			//Runnable r = () -> listen();
			//new Thread(r).start();
			new Thread(() -> listen()).start();

			speak();
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
			pln("Ŭ���̾�Ʈ ����! 2���Ŀ� ���α׷��� �����Ҳ���~");
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
