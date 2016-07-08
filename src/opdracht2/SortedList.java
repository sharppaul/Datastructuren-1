package opdracht2;

public class SortedList extends List {

	public boolean push(Student subject) {
			if (start == null) {
				start = end = subject;
				size++;
				return true;
			} else {
				addAndSort(subject);
				return true;
			}		
	}
	
	public Student pop(Student subject){
		Student current = start;
		int counter = 0;
		while(current != null){
			if(current.equals(subject))
				return super.pop(counter);
			current = current.getNext();
			counter++;
		} 
		
		return null;
	}

	private void addAndSort(Student subject) {
		Student current = start;
		while (current.getStudentNummer() < subject.getStudentNummer()) {
			current = current.getNext();
			if (current == null) {
				Student previous = end;
				previous.setNext(subject);
				end = subject;
				this.size++;
				return;
			}
		}
		Student next = current.getNext();
		current.setNext(subject);
		subject.setNext(next);
		if(next == null)
			end = subject;
		size++;
	}
}
