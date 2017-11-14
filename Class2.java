// Class object reference class
public class Class2 {

	Class2A c2a;
	Class2B c2b;
	
	public Class2(int i, char c) {
		this.c2a = new Class2A(i);
		this.c2b = new Class2B(c2a, c);
	}

	public void initializeObjects() {
		
	}
}
