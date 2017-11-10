import java.util.Scanner;

public class ObjectCreator {
	private Scanner in;
	
	public ObjectCreator() {
		in = new Scanner(System.in);
	}
	
	public void displayIntro() {
		System.out.println("Object Creator");
		System.out.println("Create objects from a list of predefined Object class templates");
	}
	
	public void displayMenu() {
		System.out.println("\nEnter the number of the Object you would like to create");
		System.out.println("1 - An object with primative instance variables");
		System.out.println("2 - An object with other objects");
		System.out.println("3 - An object with an array of primitives (5 elements long)");
		System.out.println("4 - An object with an array of other objects (3)");
		System.out.println("5 - An object with a collection of other objects");
	}
	
	public void create() {
		Object obj;
		while(true) {
			System.out.print("> ");
			String input = in.nextLine();
			if (input.equals("1")) {
				obj = createObject1();
				break;
			} else if (input.equals("2")) {
				obj = createObject2();
				break;
			} else if (input.equals("3")) {
				obj = createObject3();
				break;
			} else if (input.equals("4")) {
				obj = createObject4();
				break;
			} else if (input.equals("5")) {
				obj = createObject5();
				break;
			} else {
				System.out.println("Not a valid option.");
			}
		}
		System.out.println("Object Creator Complete!");
		System.out.println("Sending class to Serializer");
	}
	
	
	public Class1 createObject1() {
		Class1 c1 = new Class1();
		c1.setPrim1(takeBoolInput());
		c1.setPrim2(takeCharInput());
		c1.setPrim3(takeIntInput());
		System.out.println("Object 1 created");
		return c1;
	}
	
	public Class2 createObject2() {
		Class2 c2 = new Class2(takeIntInput(), takeStrInput());
		System.out.println("Object 2 created");
		return c2;
	}
	
	public Class3 createObject3() {
		Class3 c3 = new Class3();
		for (int i = 0; i < 5; i++) {
			c3.setElement(i, takeIntInput());
		}
		System.out.println("Object 3 created");
		return c3;
	}
	
	public Class4 createObject4() {
		Class4 c4 = new Class4();
		for (int i = 0; i < 3; i++) {
			c4.setClass(i, takeStrInput());
		}
		System.out.println("Object 4 created");
		return c4;
	}
	
	public Class5 createObject5() {
		Class5 c5 = new Class5();
		c5.pushClass(takeStrInput());
		System.out.println("Object 5 created");
		return c5;
	}
	
	public Boolean takeBoolInput() {
		String input;
		System.out.println("Initialize the boolean value as true or false (default is false)"); 
		while(true) {
			System.out.print("> ");
			input = in.nextLine();
			if (input.equals("true")) {
				break;
			} else if (input.equals("false")) {
				break;
			} else if (input.equals("")) {
				break;
			} else {
				System.out.println("Not a valid boolean value (true or false)");
			}
		}
		return Boolean.parseBoolean(input);
	}
	
	public Character takeCharInput() {
		String input;
		System.out.println("Initialize the character value (default is '')");
		System.out.print("> ");
		input = in.nextLine();
		return input.charAt(0);
	}
	
	public Integer takeIntInput() {
		String input;
		System.out.println("Initialize the integer value (default is -1)");
		while (true) {
			System.out.print("> ");
			input = in.nextLine();
			try {
				Integer.valueOf(input);
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("Not a valid integer");
			}
		}
		return Integer.valueOf(input);
	}
	
	public String takeStrInput() {
		String input;
		System.out.println("Initialize the String");
		System.out.print("> ");
		input = in.nextLine();
		return input;
	}
}
