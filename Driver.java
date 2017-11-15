
public class Driver {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		ObjectCreator oc =  new ObjectCreator();
		oc.displayIntro();
		oc.displayMenu();
		
		Object obj = oc.create();
		Serializer serializer = new Serializer();
		org.jdom2.Document doc = serializer.serialize(obj);
		
		Client client = new Client();
		client.sendFile(doc);
	}

}
