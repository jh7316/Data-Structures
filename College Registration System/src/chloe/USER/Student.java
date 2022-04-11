package chloe.USER;

import java.util.ArrayList;

import chloe.COURSEDATA.Course;
import chloe.INTERFACE.StudentInterface;

public class Student extends User implements StudentInterface {

	
	//Array list that stores the courses that the student is enrolled in
	private ArrayList<Course> Courses = new ArrayList<Course>();
	
	
	//getter and setter
	public ArrayList<Course> getCourses() {
		return Courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		Courses = courses;
	}

	


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String username, String password, String firstname, String lastname) {
		super(username, password, firstname, lastname);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	//view courses that are NOT full 
	public void viewCoursesNotFull(ArrayList<Course> a) {
		System.out.println("Courses you can register: ");
		int cnt=0;
		
		for (int i=0; i<a.size();i++) {		
			
			if (a.get(i).getCurStudentNum() < a.get(i).getMaxNum()) {
				System.out.println(a.get(i).getName());
			}
		}
		
		if(cnt==0) {
			System.out.println("None");
		}
	
	}
	
	//register course
	public void registerCourse(Student s,  ArrayList <Course> x, String course, int section){
		
		for (int i=0; i < x.size(); i++) {

			if ( x.get(i).getName().toLowerCase().equals(course.toLowerCase()) && x.get(i).getSectionNum()==section) {

				Courses.add(x.get(i));
				x.get(i).addStudent(s);
	
		}
		
		
		}
	}
	
	//withdraw from course 
	public void withdrawCourse(ArrayList <Course> a, Student x, String course, int section) {
			for (int i=0;i<a.size();i++) {

			
			if ( a.get(i).getName().equals(course) && a.get(i).getSectionNum()==section) {
				
				a.get(i).deleteStudent(x);
				Courses.remove(a.get(i));
			}
		}
		System.out.println("Withdrawal complete.");
		
		
	}
	
	//View courses a current student is registered in 
		public void viewStudentCourse() {
			   System.out.println("You are registered in :");
				
					for(Course c:this.getCourses()) {
						System.out.println("\t"+c.getName());
					}	
			
		}
	
	
	
	
	
	//Course Management menu for students
	public void studentCourseManagementInstructions() {
		
		
		System.out.println("1. View all courses.");
		System.out.println("2. View all courses that are not FULL.");
		System.out.println("3. Register on a course.");
		System.out.println("4. Withdraw from a course.");
		System.out.println("5. View all courses you are currenty registered in.");
		System.out.println("6. Exit.");

		
	}







}
