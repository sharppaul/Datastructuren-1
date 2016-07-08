package opdracht2;

import opdracht1.Student;

public class SortedList extends List {

	public boolean push(Student subject) {
		if (end != null) {
			Student current = start;
			Student last = end;
			while (current.getNext() != null) {
				if(current.getStudentNummer() == subject.getStudentNummer())
					return false;
				if (subject.getStudentNummer() > current.getStudentNummer()) {
					last = current;
					current = current.getNext();					
				} else {
					if(last != null)
						last.setNext(subject);
					subject.setNext(current);
					return true;
				}
			}
			current.setNext(subject);
			end = subject;
			this.size++;
			return true;
		} else {
			start = subject;
			end = start;
			this.size++;
			return true;
		}
	}
}
