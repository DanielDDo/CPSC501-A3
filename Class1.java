// Primitive class base
public class Class1 {
	
	private boolean prim1;
	private char prim2;
	private int prim3;
	
	
	public Class1() {
		this.prim1 = false;
		this.prim2 = 'a';
		this.prim3 = -1;
	}
	
	public boolean isPrim1() {
		return prim1;
	}
	
	public void setPrim1(boolean prim1) {
		this.prim1 = prim1;
	}
	
	public char getPrim2() {
		return prim2;
	}
	
	public void setPrim2(char prim2) {
		this.prim2 = prim2;
	}
	
	public int getPrim3() {
		return prim3;
	}
	
	public void setPrim3(int prim3) {
		this.prim3 = prim3;
	}
}