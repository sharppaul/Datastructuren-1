package opdracht1;

public class App {
	public static void main(String[] args) {
		Student[] s;
		s = new Student[8];
		s[0] = new Student(0, "Piet", 9, "M");
		s[1] = new Student(1, "Klaas", 91, "M");
		s[2] = new Student(2, "Jan", 19, "M");
		s[3] = new Student(3, "Henk", 39, "M");
		s[4] = new Student(4, "Pieternella", 9, "V");
		s[5] = new Student(5, "Klaasientje", 91, "V");
		s[6] = new Student(6, "Janette", 19, "V");
		s[7] = new Student(7, "Henkolien", 39, "V");	
		
		Stack stack = new Stack();
		for(int i = 0; i < s.length; i++){
			stack.push(s[i]);
		}
		stack.printStack();
		stack.printMen();
		stack.printWomen();
	}
}
