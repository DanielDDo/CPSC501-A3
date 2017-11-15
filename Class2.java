// Class object reference class
public class Class2 {

	Class2A c2a;
	Class2B c2b;
	
	public Class2() {
	}
	
	public void setClass2A(Class2A c2a) {
		this.c2a = c2a;
	}
	
	public void setClass2B(Class2B c2b) {
		this.c2b = c2b;
	}
	
	public void initClass2A(int i) {
		this.c2a = new Class2A();
		this.c2a.setInt1(i);
	}
	
	public void initClass2B(char c) {
		this.c2b = new Class2B();
		this.c2b.setClass2A(c2a);
		this.c2b.setChar1(c);
	}
	
	
}
