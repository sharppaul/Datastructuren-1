package opdracht2;


public class Queue {
	protected Student start;
	protected Student end;
	protected int size = 0;

	public boolean push(Student subject){
		if (start == null) {
			start = end = subject;
			size++;
			return true;
		} else {
			end.setNext(subject);
			end = subject;
			size++;
			return true;
		}	
	}

	public int getSize() {
		return this.size;
	}

	public Student pop() {
		if(start.getNext() != null){
			Student temp = start;
			start = start.getNext();
			size--;
			return temp;
		}
		if(start != null)
			size--;
		return start;
		
	}

	public boolean peek(Student subject) {
		if (start == null)
			return false;

		Student current = start;
		while (current != end) {
			if (current.getStudentNummer() == subject.getStudentNummer())
				return true;
			current = current.getNext();
		}

		return false;
	}

	
	//Print methods:

	public void print() {
		Student current = start;
		System.out.println("\tData: [\n");
		while(current != null){
			System.out.println(current.toString());
			current = current.getNext();
		} 
		System.out.println("\t]");
	}

	public void printMen() {
		Student current = start;
		System.out.println("\tMen: [\n");
		while(current != null){
			if (current.getGeslacht().equals("M"))
				System.out.println(current.toString());
			current = current.getNext();
		}
		System.out.println("\t]");
	}

	public void printWomen() {
		Student current = start;
		System.out.println("\tWomen: [\n");
		while(current != null){
			if (current.getGeslacht().equals("V"))
				System.out.println(current.toString());
			current = current.getNext();
		} 
		System.out.println("\t]");
	}
}
