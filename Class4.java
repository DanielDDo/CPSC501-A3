
public class Class4 {
	Class4A[] c4a;
	
	public Class4() {
		this.c4a = new Class4A[3];
	}
	
	public void setClass(int index, String s) {
		Class4A c4a = new Class4A(s);
		this.c4a[index] = c4a;
	}
}
