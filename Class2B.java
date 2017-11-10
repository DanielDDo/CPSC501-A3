
public class Class2B {

		private String string1;
		private Class2A c2a;
		
		public Class2B(Class2A c2a, String s) {
			this.c2a = c2a;
			this.string1 = s;
		}

		public String getString1() {
			return string1;
		}

		public void setString1(String string1) {
			this.string1 = string1;
		}
}
