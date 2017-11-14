import java.util.ArrayList;

public class Class5 {
	public ArrayList<Class5A> list;
	
	public Class5() {
		list = new ArrayList<Class5A>();
	}
	
	public void pushClass(String s) {
		Class5A c5a = new Class5A(s);
		list.add(c5a);
	}
}
