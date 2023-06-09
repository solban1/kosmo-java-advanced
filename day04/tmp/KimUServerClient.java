import java.io.*;
import java.net.*;
import java.util.*;

class KimUServerClient{
	int port = 6000;
	DatagramSocket ds; //메세지함 (우체통)
	DatagramPacket dp; //메세지틀 (편지봉투)
	DatagramPacket dp1;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String ip;
	InetAddress ia;

	FileReader fr;
	String line = "";
	HashMap<String, String> ipMap = new HashMap<>();
	String name;
	String getName;

	KimUServerClient(){
		try{
			ds = new DatagramSocket(port);
			pln(port+"번 포트에서 UDP서버 대기중..");
			byte bs[] = new byte[2048];
			dp = new DatagramPacket(bs, bs.length);
			new Thread(() -> speak()).start();
			while(true){
				ds.receive(dp);
				String msg = new String(bs);
				msg = msg.trim();
				pln("Client>> " + msg);
				for(int i=0; i<bs.length; i++) bs[i]=0;
			}
		}catch(SocketException se){
		}catch(IOException ie){
		}finally{
			if(ds != null) ds.close();
		}
	}

	public static void main(String[] args) {
		new KimUServerClient();
	}

	void speak(){
		inputIp();
		try{
			while(true){
				p("전달할메세지: ");
				String msg = br.readLine();
				msg = msg.trim();
				byte bs[] = msg.getBytes();
				dp1 = new DatagramPacket(bs, bs.length, ia, port);
				ds.send(dp1);
				pln("전송완료!");
			}
		}catch(SocketException se){
		}catch(IOException ie){
		}finally{
			if(ds != null) ds.close();
		}
	}

	void inputIp(){
		ipListRead();
		try{
			pln("아무것도 입력하지않으면 기본 IP(192.168.0.253)");
			p("이름을 입력하면 그 사람의 IP로 연결됩니다 : ");
			getName = br.readLine();
			if(getName != null){
				getName = getName.trim();
			}
			if(ip.length() == 0){
				ip = "192.168.0.253";
			}else{
				ip = ipMap.get(getName);
			}
			ia = InetAddress.getByName(ip);
		}catch(IOException ie){
			pln(ip + "가 이상해요");
		}
	}
		/*
		try{
			p("IP(기본:192.168.0.253): ");
			ip = br.readLine();
			ip = ip.trim();
			if(ip.length() == 0) ip = "192.168.0.253";
			ia = InetAddress.getByName(ip);
		}catch(IOException ie){
			pln(ip + "가 이상해요");
		}
		*/
	
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}

	void ipListRead(){
		try{
			fr = new FileReader("ips.txt");
			br = new BufferedReader(fr);

			while((line = br.readLine()) != null){
				line = line.trim();
				if(line.length()==0){ //줄이 비어있으면 넘어간다.
					continue;
				}
				int idx = line.indexOf(" ");
				if(idx != -1){ //공백이 있을 경우
					name = line.substring(0, idx); //0<= val <idx // 공백 나오는 위치까지 = 이름
					ip = line.substring(idx+1); //공백 이후부터 나오는 값 = ip
					ipMap.put(name, ip); // key = 이름, value = ip 
					//pln(ipMap.get(name));
				}
			}
		}catch(FileNotFoundException fe){
			System.out.println("파일을 찾을 수 없습니다");
		}catch(IOException ie){
		}

	}

}
