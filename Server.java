import java.net.*;
import java.io.*;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class Server {
	
	org.jdom2.Document doc;
	public Server() {
	
	}
	
	public org.jdom2.Document receive() {
		try {
			System.out.println("Server waiting for Client");
			ServerSocket ss = new ServerSocket(1634);
			Socket s = ss.accept();
			System.out.println("Client connected");
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
			SAXBuilder build = new SAXBuilder();
			System.out.println("Building XML Document . . .");
			this.doc = build.build(dis);
			System.out.println("Complete");
			
			dis.close();
			ss.close();
		} catch (IOException e) {
		} catch (JDOMException e) {
		}		
		return doc;
	}
}
