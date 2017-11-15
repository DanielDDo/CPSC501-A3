

public class ServerDriver {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Server server = new Server();
		org.jdom2.Document doc = server.receive();
		Deserializer deserializer = new Deserializer();
		Object obj = deserializer.deserialize(doc);
	
		Visualizer visualizer = new Visualizer();
		visualizer.inspect(obj, true);
	}
}
