package opdracht2;

import opdracht1.Student;

public class Queue extends List{
	public boolean push(Student subject) {
		return super.push(subject, size);
	}
	
	public Student pop(){
		return super.head();
	}
}
