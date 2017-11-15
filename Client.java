import java.net.*;
import java.io.*;
import org.jdom2.output.*;

public class Client {

	private Socket socket;
	private XMLOutputter op;
	
	public Client() {
	}
	
	public boolean sendFile(org.jdom2.Document xmlDoc) {
		try {
			socket = new Socket("localhost", 1634);
			op = new XMLOutputter();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("Sending XML Document to the server");
			op.output(xmlDoc, dos);
			
			dos.close();
		} catch (IOException e) {
			return false;
		}		
		return true;
	}
}
