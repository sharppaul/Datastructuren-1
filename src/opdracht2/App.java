package opdracht2;


public class App {
	public static void main(String[] args) {
		Student[] s;
		s = new Student[8];
		s[0] = new Student(0, "Piet", 9, "M");
		s[1] = new Student(1, "Klaas", 91, "M");
		s[2] = new Student(2, "Jan", 19, "M");
		s[3] = new Student(4, "Henk", 39, "M");
		s[4] = new Student(5, "Pieternella", 9, "V");
		s[5] = new Student(1, "Klaasientje", 91, "V");
		s[6] = new Student(2, "Janette", 19, "V");
		s[7] = new Student(7, "Henkolien", 39, "V");	
		
		/*
		Queue queue = new Queue();
		for(int i = 0; i < s.length; i++){
			queue.push(s[i]);
		}
		
		queue.printQueue();
		
		System.out.println(queue.pop().toString());
		
		queue.printMen();
		queue.printWomen();
		*/
		
		
		SortedList sortedList = new SortedList();
		for(int i = 0; i < s.length; i++){
			sortedList.push(s[i]);
		}
		
		System.out.println("###########LIST############");
		sortedList.print();
		
		System.out.println("###########POP(s[2])#############");
		System.out.println(sortedList.pop(s[2]).toString());
		
		System.out.println("###########TAIL#############");
		System.out.println(sortedList.tail().toString());
		
		System.out.println("###########HEAD#############");
		System.out.println(sortedList.head().toString());
		
		System.out.println("###########MEN##############");
		sortedList.printMen();

		System.out.println("###########WOMEN############");
		sortedList.printWomen();
		
	}
}
