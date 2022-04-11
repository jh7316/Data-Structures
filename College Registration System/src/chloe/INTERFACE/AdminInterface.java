package chloe.INTERFACE;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import chloe.COURSEDATA.Course;
import chloe.USER.Student;

public interface AdminInterface {
	//create new course
	public abstract Course newCourse(String courseName, String courseID, int maxStudents, String instructor,
			int courseSection, String courseLocation, ArrayList<Course> courseArr);
	
	//delete course
	public abstract void deleteCourse(ArrayList<Course> courseArr, String x);
	
	//edit course
	public abstract void editCourse(String courseName, int maxStudents, String instructor,
			int courseSection, String courseLocation, ArrayList<Course> courseArr);
	
	//display course info(By ID)
	public abstract void displayCourse(String courseName, ArrayList <Course> x);
	
	//Register student
	public abstract void registerStudent(ArrayList<Student> student, String firstname, String lastname);
	
	//View all courses that are full 
	public abstract void viewFullCourses(ArrayList<Course> x);
	
	//write to file the list of courses that are full
	public abstract void writeToFile(ArrayList<Course> x) throws FileNotFoundException, UnsupportedEncodingException;
	
	
	//view names of students being registered in a specific course
	public abstract void viewRegisteredStudents(ArrayList <Course> x, String course);
	
	
	//sort courses based on current no. of student registers 
	public abstract void Sort(ArrayList<Course>  x);
	
	

}
