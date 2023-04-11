//ZHANG Zhile
//MOULHERAT Hadrien

package tp;
import java.io.*;
import java.net.Socket;

public class client_tcp {
	
	final static int PORT = 4242;
	
	public static void main(String[] args) throws IOException {
		//Creation de la socket du server
		Socket socket = new Socket("localhost", PORT);
		
		//Preparation et envoie du message au serveur
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		PrintWriter w = new PrintWriter(out, true);
		w.println("message");
		
		//Attente de la reponse du serveur
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//Affichage de la reponse recue
		System.out.println(in.readLine());
		
		in.close();
		out.close();
		
		//Fermeture de la connexion
		socket.close();
	}

}
