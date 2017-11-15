import java.util.List;

import org.jdom2.Element;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Deserializer {
	private HashMap<Integer,Object> objTracker;
	public Deserializer() {	
		objTracker = new HashMap<Integer,Object>();
	}
	
	public Object deserialize(org.jdom2.Document doc) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		System.out.println("Starting Deserialization");
		Object obj = null;
		Element root = doc.getRootElement(); // serialized element
		List<Element> xmlObjects = root.getChildren();
		Element classObject = xmlObjects.get(0);
		String className = classObject.getAttributeValue("class");
		if (className.equals("Class1")) {
			obj = recreateClass1(root);
		} else if (className.equals("Class2")) {
			obj = recreateClass2(root);
		}

		return obj;
		
	}
	
	public Class1 recreateClass1(Element root) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class1 c1 = new Class1();
		Class classObject = c1.getClass();
		List<Element> objects = root.getChildren();
		
		for (Element o : objects) {
			List<Element> fields = o.getChildren();
			for (Element f : fields) {
				List<Element> values = f.getChildren();
				String value = values.get(0).getText();
				String fieldName = f.getAttributeValue("name");
				Field field = classObject.getDeclaredField(fieldName);
				field.setAccessible(true);
				Object fieldType = field.getType();
				if (fieldType.equals(boolean.class)) {
					field.setBoolean(c1, Boolean.getBoolean(value));
				} else if (fieldType.equals(char.class)) {
					field.setChar(c1, value.charAt(0));
				} else if (fieldType.equals(int.class)) {
					field.setInt(c1, Integer.valueOf(value));
				}
			}
		}
		return c1;
	}
	
	public Class2 recreateClass2(Element root) throws NoSuchFieldException, SecurityException, NumberFormatException, IllegalArgumentException, IllegalAccessException {
		Class2 c2 = new Class2();
		List<Element> objects = root.getChildren();

		Class2A c2a = new Class2A();
		Class classObject = c2a.getClass();
		Element object = objects.get(1);
		List<Element> fields = object.getChildren();
		for (Element f : fields) {
			List<Element> values = f.getChildren("value");
			String value = values.get(0).getText();
			String fieldName = f.getAttributeValue("name");
			Field field = classObject.getDeclaredField(fieldName);
			field.setAccessible(true);
			Object fieldType = field.getType();
			if (fieldType.equals(int.class)) {
				field.setInt(c2a, Integer.valueOf(value));
			}
		}
		String id = object.getAttributeValue("id");
		objTracker.put(Integer.valueOf(id), c2a);
		
		Class2B c2b = new Class2B();
		classObject = c2b.getClass();
		object = objects.get(2);
		fields = object.getChildren();
		for (Element f1 : fields) {
			List<Element> values = f1.getChildren();
			for (Element v : values) {
				if (v.getName().equals("value")) {
					String value = values.get(0).getText();
					String fieldName = f1.getAttributeValue("name");
					Field field = classObject.getDeclaredField(fieldName);
					field.setAccessible(true);
					Object fieldType = field.getType();
					if (fieldType.equals(char.class)) {
						field.setChar(c2b, value.charAt(0));
					}
				} else if (v.getName().equals("reference")){
					String reference = values.get(0).getText();
					String fieldName = f1.getAttributeValue("name");
					Field field = classObject.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(c2b, objTracker.get(Integer.valueOf(reference)));
				}
			}
		}
		id = object.getAttributeValue("id");
		objTracker.put(Integer.valueOf(id), c2b);
		
		classObject = c2.getClass();
		object = objects.get(0);
		fields = object.getChildren();
		for (Element f2 : fields) {
			List<Element> values = f2.getChildren();
			for (Element v : values) {
				if (v.getName().equals("reference")) {
					String reference = values.get(0).getText();
					String fieldName = f2.getAttributeValue("name");
					Field field = classObject.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(c2, objTracker.get(Integer.valueOf(reference)));
				}
			}
		}
		return c2;
		
	}
}
