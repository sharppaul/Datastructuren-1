package opdracht1;

public class Stack {
	private Student start;
	private int size = 0;

	public void push(Student subject) {
		subject.setNext(start);
		start = subject;
		this.size++;
	}

	public int getSize() {
		return this.size;
	}

	public Student pop() {
		if (start != null) {
			if (start.getNext() != null) {
				Student temp = start;
				start = start.getNext();
				this.size--;
				return temp;
			}
			this.size--;
			return start;
		}
		return start;
	}

	public boolean peek(Student subject) {
		if (start == null)
			return false;

		Student current = start;
		while (current.getStudentNummer() != subject.getStudentNummer()) {
			if (current.getNext() == null)
				return false;

			current = current.getNext();
		}
		return true;
	}

	public void printStack() {
		System.out.println("Stack [\n");
		if (start != null) {
			Student current = start;
			do {
					System.out.println(current.toString());
				
				if (current.getNext() != null)
					current = current.getNext();
			} while (current.getNext() != null);
		}
		System.out.println("]\n");
	}

	public void printMen() {
		System.out.println("Stack with men [\n");
		if (start != null) {
			Student current = start;
			do {
				if (current.getGeslacht().equals("M"))
					System.out.println(current.toString());
				
				if (current.getNext() != null)
					current = current.getNext();
			} while (current.getNext() != null);
		}
		System.out.println("]\n");
	}

	public void printWomen() {
		System.out.println("Stack with women [\n");
		if (start != null) {
			Student current = start;
			do {
				if (current.getGeslacht().equals("V"))
					System.out.println(current.toString());
				
				if (current.getNext() != null)
					current = current.getNext();
			} while (current.getNext() != null);
		}
		System.out.println("]\n");
	}
}
