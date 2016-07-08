package opdracht2;

import opdracht1.Student;

public class List {
	protected Student start;
	protected Student end;
	protected int size = 0;

	public boolean push(Student subject, int index) {
		if (end != null) {
			Student current = start;
			while (current != end) {
				current = current.getNext();
				if(current.getIndex() == index)
					return false;
			}
			if(current.getIndex() == index)
				return false;
			current.setNext(subject);
			subject.setIndex(index);
			end = subject;
			this.size++;
			return true;
		} else {
			subject.setIndex(index);
			start = subject;
			end = start;
			this.size++;
			return true;
		}
	}

	public int getSize() {
		return this.size;
	}

	public Student head() {
		if (start != null) {
			Student temp = start;
			start = temp.getNext();
			size--;
			return temp;
		}
		return null;
	}
	
	public Student tail() {
		if (start != null) {
			if(start == end){
				Student temp = start;
				start = null;
				end = null;
				size--;
				return temp;
			}
			
			Student current = start;
			while (current.getNext() != end) {
				current = current.getNext();
			}
			
			Student temp = end;
			end = current;
			end.setNext(null);
			
			return temp;
		}
		return null;
	}
	
	public Student pop(int index) {
		Student current = start;
		do {
			if (current.getIndex() == index){
				size--;
				return current;
			}
			if(current != end)
				current = current.getNext();
		} while (current.getNext() != null);
		return null;
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

	public void printQueue() {
		Student current = start;
		System.out.println("Queue [");
		do {
			System.out.println(current.toString());
			current = current.getNext();
		} while (current != end);
		System.out.println("]");
	}

	public void printMen() {
		Student current = start;
		System.out.println("Queue men: [");
		do {
			if (current.getGeslacht().equals("M"))
				System.out.println(current.toString());
			current = current.getNext();
		} while (current != end);
		System.out.println("]");
	}

	public void printWomen() {
		Student current = start;
		System.out.println("Queue women[");
		do {
			if (current.getGeslacht().equals("V"))
				System.out.println(current.toString());
			current = current.getNext();
		} while (current != end);
		System.out.println("]");
	}

	
}
