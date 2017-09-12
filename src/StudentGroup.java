import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else{
			/*for(int i=0;i<students.length;i++){
				//this.students[i] = students[i];
				this.students[i].setId(students[i].getId());
				this.students[i].setFullName(students[i].getFullName());
				this.students[i].setBirthDate(students[i].getBirthDate());
				this.students[i].setAvgMark(students[i].getAvgMark());
			}*/
			this.students = new Student[students.length];
			this.students = students;
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			return students[index];
		}
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			//students[index].setId(student.getId());
			//students[index].setAvgMark(student.getAvgMark());
			//students[index].setBirthDate(student.getBirthDate());
			//students[index].setFullName(student.getFullName());
			students[index]=student;
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else{
			Student[] students1 = new Student[students.length+1];
			students1[0]=student;
			for(int i=0;i<students.length;i++){
				students1[i+1]=students[i];
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else{
			Student[] students1 = new Student[students.length+1];
			students1[students1.length-1]=student;
			for(int i=0;i<students1.length-1;i++){
				students1[i]=students[i];
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			Student[] students1 = new Student[students.length+1];
			students1[index] = student;
			for(int i=0;i<index;i++){
				students1[i] = students[i];
			}
			for(int i=index;i<students.length;i++){
				students1[i+1] = students[i];
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			Student[] students1 = new Student[students.length-1];
			for(int i=0;i<index;i++){
				students1[i] = students[i];
			}
			for(int i=index+1;i<students.length;i++){
				students1[i-1] = students[i];
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		for(int j=0;j<students.length;j++){
			if(student.compareTo(students[j]) == 0){
				int index = j;
				Student[] students1 = new Student[students.length-1];
				for(int i=0;i<index;i++){
					students1[i] = students[i];
				}
				for(int i=index+1;i<students.length;i++){
					students1[i-1] = students[i];
				}
				students = new Student[students1.length];
				for(int i=0;i<students.length;i++){
					students[i]=students1[i];
				}
				break;
			}
			throw new IllegalArgumentException("Student not exist");
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			int len = students.length-index;
			Student[] students1 = new Student[students.length-len+1];
			for(int i=0;i<students1.length;i++){
				students1[i] = students[i];
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else{
			for(int j=0;j<students.length;j++){
				if(student.compareTo(students[j]) == 0){
					int index = j;
					int len = students.length-index;
					Student[] students1 = new Student[students.length-len+1];
					for(int i=0;i<students1.length;i++){
						students1[i] = students[i];
					}
					students = new Student[students1.length];
					for(int i=0;i<students.length;i++){
						students[i]=students1[i];
					}
				}
			}
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			int len = students.length-index;
			Student[] students1 = new Student[students.length-len+1];
			int j=0;
			for(int i=index;i<students1.length;i++){
				students1[j] = students[i+1];
				j++;
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else{
			for(int j=0;j<students.length;j++){
				if(student.compareTo(students[j]) == 0){
					int index = j;
					int len = students.length-index;
					Student[] students1 = new Student[students.length-len+1];
					int k=0;
					for(int i=index;i<students1.length;i++){
						students1[k] = students[i+1];
						k++;
					}
					students = new Student[students1.length];
					for(int i=0;i<students.length;i++){
						students[i]=students1[i];
					}
				}
			}
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		Student temp;
		for(int i=0; i < students.length; i++){  
            for(int j=1; j < (students.length-i); j++){  
                     if(students[j-1].getAvgMark() > students[j].getAvgMark()){  
                            //swap elements  
                            temp = students[j-1];  
                            students[j-1] = students[j];  
                            students[j] = temp;  
                    }  
            	}      
            }  
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		Student[] bdate = null;
		int j=0;
		if(date == null){
			throw new IllegalArgumentException();
		}
		else{	
			for(int i=0;i<students.length;i++){
				if(students[i].getBirthDate().compareTo(date)<=0){
					bdate[j]=students[i];
					j++;
				}
			}
			return bdate;
		}
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
