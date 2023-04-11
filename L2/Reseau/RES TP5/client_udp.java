//ZHANG Zhile
//MOULHERAT Hadrien

package tp;
import java.io.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class client_udp {

	final static int PORT = 4242;
	final static int BUFF_SIZE = 1024;
	
	public static void main(String[] args) throws IOException {
		//Creation de la socket client UDP
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		DatagramSocket socket = new DatagramSocket();
		//Thread.sleep(1000);
		//Preparation du message a envoyer
			//Le message en type String
			String msg = "Hello World!";
			
			//le String est converti en tableau Byte
			byte[] msgByte = msg.getBytes();
			
			//Creation du paquet
			byte[] buffer = new byte[BUFF_SIZE];
			DatagramPacket packet1 = new DatagramPacket(buffer, BUFF_SIZE, ip, PORT);
			packet1.setData(msgByte);
			
		//Envoie du message
		socket.send(packet1);
		
		//Attente de la reponse du serveur
		socket.receive(packet1);
		
		//Lecture et affichage des donnees recues
			//Recuperation des donnees recues
			int len = packet1.getLength();
			byte[] data = packet1.getData();
			
			String str = new String(data, 0, len);
			
			//Affichage
			System.out.println(str);
		
		//Fermeture de la socket
		socket.close();
	}

}

