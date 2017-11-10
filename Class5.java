import java.util.Stack;

public class Class5 {
	public Stack<Class5A> stack;
	
	public Class5() {
		stack = new Stack<Class5A>();
	}
	
	public void pushClass(String s) {
		Class5A c5a = new Class5A(s);
		stack.push(c5a);
	}
}
