//ZHANG Zhile
//MOULHERAT Hadrien

package tp;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class server_tcp {
	
	final static int PORT = 4242;
	
	public static void main(String[] args) throws IOException {
		//Creation de la socket du server
		ServerSocket sSocket = new ServerSocket(PORT);
		
		//Ecoute sur un port et l attente d un paquet
		Socket client = sSocket.accept();
		
		//Reception et affichage des donnees recues
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		System.out.println(in.readLine());
		
		//Creation et envoie de la reponse
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		PrintWriter w = new PrintWriter(out, true);
		w.println("reponse");
		
		//Fermeture des sockets
		out.close();
		in.close();
		client.close();
		sSocket.close();
	}
}
