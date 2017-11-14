
public class Driver {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		ObjectCreator oc =  new ObjectCreator();
		oc.displayIntro();
		oc.displayMenu();
		
		Object obj = oc.createObject4();
		Serializer serializer = new Serializer();
		serializer.serialize(obj);
		
	}

}
