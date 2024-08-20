package Week3;

public class Student {
	public static String DEFAULT_MAJOR = "Computer Science"; // static field
	// (multiple) constructors
	public Student() {}
	public Student(String fName, String lName, int a) {
		firstName = fName;
		lastName = lName;
		age = a;
	}
	// state: instance variables
	public String lastName = "";
	public String firstName = "";
	public int age = 0;
	// behavior: methods
	public String getFullName() {
		return firstName + " " + lastName;
	}

	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//return super.equals(obj);
		
		// checking if the two objects 
        // pointing to same object 
        if (this == obj) 
            return true; 
  
        // checking for two condition: 
        // 1) object is pointing to null 
        // 2) if the objects belong to same class or not 
        if (obj == null
            || this.getClass() != obj.getClass()) 
            return false; 
  
        Student s1 = (Student)obj; // type casting object to the intended class type 
  
        // checking if the two  
        // objects share all the same values 
        return this.firstName.equals(s1.firstName) 
            && this.age == s1.age 
            && this.lastName.equals(s1.lastName); 
	}
	
}
