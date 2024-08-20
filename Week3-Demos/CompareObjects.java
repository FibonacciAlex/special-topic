package Week3;

public class CompareObjects {
	
	public static void main(String[] args) {
		Student aStudent = new Student("John","Smith",20);
		//Student anotherStudent = aStudent;
		//Student anotherStudent = modify(aStudent);
		Student anotherStudent = new Student("John","Smith",20);

		System.out.println(anotherStudent == aStudent);
		System.out.println(aStudent);
		System.out.println(anotherStudent);
		System.out.println(anotherStudent.equals(aStudent));
		
		// static field, just one copy shared by all the instances, ClassName.fieldname
		Student.DEFAULT_MAJOR="IT";
		System.out.println(anotherStudent.DEFAULT_MAJOR);

		int a=3;
		int b=3;
		System.out.println(a == b);
		
		String c="3";
		String d=new String("3");
		System.out.println(c==d);
		System.out.println(c.equals(d));
		
	}
	
	public static Student modify(Student s) {
		s.age = 22;
		return s;
	}

}