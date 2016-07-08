package opdracht2;


public class List extends Queue{
	
	@Override
	public boolean push(Student subject){
		return this.push(subject, size);
	}
	
	public boolean push(Student subject, int index) {
		if(index > this.size || index < 0)
			return false; //could throw outofbounds?
		
		if(index == this.size){
			end.setNext(subject);
			end = subject;
			size++;
			return true;
		}
		
		Student last = null;
		Student current = start;
		for(int i = 0; i <= index; i++){
			last = current;
			current = current.getNext();
		}
		last.setNext(subject);
		subject.setNext(current);
		size++;
		return true;
	}

	public int getSize() {
		return this.size;
	}

	public Student head() {
		if (start != null) {
			Student temp = start;
			if(temp.getNext() != null)
				start = temp.getNext();
			size--;
			return temp;
		}
		return start;
	}
	
	public Student tail() {
		if (start != null) {
			Student secondLast = start;
			Student end = start;
			
			while(secondLast.getNext() != null){
				if(secondLast.getNext().getNext() == null){
					end = secondLast.getNext();
					break;
				}
				secondLast = secondLast.getNext();
			}
			this.end = secondLast;
			this.end.setNext(null);
			this.size--;
			return end;
		}
		return null;
	}
	
	public Student pop(int index) throws IndexOutOfBoundsException {
		if(index == 0)
			return head();
		
		if(index == this.size - 1){
			return tail();
		}
		
		if(index >= this.size || index < 0)
			throw new IndexOutOfBoundsException();
		
		Student last = null;
		Student current = start;
		for(int i = 0; i <= index; i++){
			last = current;
			current = current.getNext();
		}

		Student temp = current;
		last.setNext(current.getNext());
		size--;
		return temp;		
	}

	
}
