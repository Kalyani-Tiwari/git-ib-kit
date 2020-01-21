//Data Access Object Design Pattern Implementation Example
//DONE
import java.util.*;
//Model class
class Student{
	int rollno;
	String name;
	Student(String name, int rollno){
		this.name = name;
		this.rollno = rollno;
	}

	String getName(){
		return name;
	}
	int getRollno(){
		return rollno;
	}
	void setName(String x){
		name = x;
	}
	void setRollno(int x){
		rollno = x;
	}
}

//DAO interface
interface StudentDao{
	public List<Student> getStudents();
	public void updateStudent(String name1, String name2);
	public void deleteStudent(int index);
	public void addStudent(Student s);
}

//DAO concrete class
class StudentDaoImpl implements StudentDao{
List<Student> students;
StudentDaoImpl(){
students = new ArrayList<Student>();
}

public List<Student> getStudents(){
	return students;
}

public void addStudent(Student s){
	students.add(s);
}

public void deleteStudent(int index){
	//Student s = students.get(index);
	students.remove(index);
}
public void updateStudent(String name1, String name2){
	//Iterator<Student> itr = students.iterator();
	for(Student x : students){
		if(x.getName().equals(name1)) x.setName(name2);
	}
}
}

public class ExecuteDAO{
public static void main(String args[]){
	StudentDao studentDao = new StudentDaoImpl();
	Student s = new Student("Pratik", 1);
	studentDao.addStudent(s);
	s = new Student("Swaru", 2);
	studentDao.addStudent(s);

	//print all students
	for (Student student : studentDao.getStudents()) {
	 System.out.println("RollNo : " + student.getRollno() + ", Name : " + student.getName());
	}


	//update student
	studentDao.updateStudent("Pratik", "John");

	//get the student
	System.out.println("Students after updating :");
	for (Student student : studentDao.getStudents()) {
	System.out.println("RollNo : " + student.getRollno() + ", Name : " + student.getName());
	}
}
}
