import org.jdom2.*;

import java.io.IOException;
import java.lang.Object;
import java.lang.reflect.*;

import org.jdom2.output.*;

import java.util.IdentityHashMap;
import java.util.LinkedList;

public class Serializer {

	private IdentityHashMap<Object,Integer> objTracker;
	private LinkedList<Object> queue;
	
	public Serializer() {
		objTracker = new IdentityHashMap<Object,Integer>();
		queue = new LinkedList<Object>();
	}
	
	public org.jdom2.Document serialize(Object obj) throws IllegalArgumentException, IllegalAccessException {
		System.out.println("Serializing Object\n . . .\n");
		XMLOutputter op = new XMLOutputter();
		op.setFormat(Format.getPrettyFormat());		
		Element root = new Element("serialized");
		Document doc = new Document(root);
		
		objTracker.put(obj, obj.hashCode());
		queue.add(obj);
		
		Element fieldElement;
		Element valueElement;
		Element referenceElement;
		while(queue.peek() != null) {
			Object o = queue.poll();
			Element objectElement = new Element("Object");
			objectElement.setAttribute("class", o.getClass().getName());
			objectElement.setAttribute("id", String.valueOf(o.hashCode()));
			if (!o.getClass().isArray()) {
				Field[] fields = o.getClass().getDeclaredFields();
				for (Field f : fields) {
					fieldElement = new Element("field");
					f.setAccessible(true);
					fieldElement.setAttribute("name", f.getName());
					fieldElement.setAttribute("declaringclass", f.getDeclaringClass().getName());
					if (f.getType().isPrimitive()) {
						valueElement = new Element("value");
						valueElement.setText(String.valueOf(f.get(o)));
						fieldElement.addContent(valueElement);
					} else {
						referenceElement = new Element("reference");
						Object ob = f.get(o);
						int objRef = ob.hashCode();
						referenceElement.setText(String.valueOf(objRef));
						fieldElement.addContent(referenceElement);
						if (!objTracker.containsKey(ob)) {
							objTracker.put(ob, objRef);
							queue.add(ob);
						}
					}
					objectElement.addContent(fieldElement);
				}
			} else {
				int length = Array.getLength(o);
				objectElement.setAttribute("len", String.valueOf(length));
				if (o.getClass().getComponentType().isPrimitive()) {
					for (int i = 0; i < length; i++) {
						valueElement = new Element("value");
						valueElement.setText(String.valueOf(Array.get(o, i)));
						objectElement.addContent(valueElement);
					}
				} else {
					for (int i = 0; i < length; i++) {
						referenceElement = new Element("reference");
						Object ob = Array.get(o, i);
						int objRef = ob.hashCode();
						referenceElement.setText(String.valueOf(objRef));
						objectElement.addContent(referenceElement);
						if (!objTracker.containsKey(ob)) {
							objTracker.put(ob, objRef);
							queue.add(ob);
						}
					}
				}
			}
			root.addContent(objectElement);
		}
		System.out.println("Serialization Complete!");
		try {
			op.output(doc, System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
}
