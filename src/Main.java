import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		
		Student s1 = new Student(1,"ab",new Date(),12); 
		Student s2 = new Student(2,"bc",new Date(),22); 
		StudentGroup sg1 = new StudentGroup(1);
		sg1.setStudent(s1, 0);
		//sg1.addFirst(s2);
		sg1.addLast(s2);
		Student s3;
		s3 = sg1.getStudent(1);
		System.out.println(s3.getId());
		sg1.remove(0);
		
	}

}
