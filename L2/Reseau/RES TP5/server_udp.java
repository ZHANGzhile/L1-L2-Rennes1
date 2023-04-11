//ZHANG Zhile
//MOULHERAT Hadrien

package tp;
import java.io.*;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class server_udp {
	
	final static int PORT = 4242;
	final static int BUFF_SIZE = 1024;
	
	public static void main(String[] args) throws IOException {
		
		//Creation de la socket serveur UDP
		//InetAddress localhost = InetAddress.getByName("127.0.0.1");
		DatagramSocket socket = new DatagramSocket(PORT);
		
		//Creation du buffer de reception
		byte[] buffer = new byte[BUFF_SIZE];
		DatagramPacket packet1 = new DatagramPacket(buffer, BUFF_SIZE);
		
		//Attente du paquet
		socket.receive(packet1);
		
		//Affichage des donnees recues
		int len = packet1.getLength();
		byte[] data = packet1.getData();
		
		String str = new String(data, 0, len - 1);
		System.out.println(str);
		
		//Preparation du paquet reponse
		byte[] buffer2 = new byte[BUFF_SIZE];
		
		DatagramPacket packet2 = new DatagramPacket(buffer2, BUFF_SIZE);
		packet2.setSocketAddress(packet1.getSocketAddress());
		
		String reponse = "Ack";
		byte[] reponseByte = reponse.getBytes();
		packet2.setData(reponseByte);
		
		//Envoie du paquet reponse
		socket.send(packet2);
		
		//Fermeture de la socket
		socket.close();
	}
}
