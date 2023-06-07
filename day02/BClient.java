import java.net.*;
import java.io.*;

class BClient {
	String ipServer = "192.168.0.90";//127.0.0.1==localhost
	int port = 4000;
	Socket s;

	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;
	BClient(){
		try{
			s = new Socket(ipServer, port);
			pln("������ ���Ӽ���!!");

			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			is = s.getInputStream();
			dis = new DataInputStream(is);

			Runnable r = () -> listen();
			new Thread(r).start();

			speak();
		}catch(UnknownHostException ue){
		}catch(IOException ie){
		}finally{
			try{
				s.close();
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
			pln("���� ����! 2���Ŀ� ���α׷��� �����Ҳ���~");
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
		BClient client = new BClient();
	}
}
