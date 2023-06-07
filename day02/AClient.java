import java.net.*;
import java.io.*;

class AClient {
	String ipServer = "192.168.0.90";//127.0.0.1==localhost
	int port = 4000;
	Socket s;

	OutputStream os;
	DataOutputStream dos;
	AClient(){
		try{
			s = new Socket(ipServer, port);
			pln("辑滚客 立加己傍!!");

			os = s.getOutputStream();
			dos = new DataOutputStream(os);

			speak();
		}catch(UnknownHostException ue){
		}catch(IOException ie){
		}finally{
			try{
				s.close();
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
		AClient client = new AClient();
	}
}
