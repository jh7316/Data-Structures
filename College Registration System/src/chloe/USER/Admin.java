package chloe.USER;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import chloe.COURSEDATA.Course;
import chloe.INTERFACE.AdminInterface;

public class Admin extends User implements AdminInterface{

	
	private static final String Username="Admin";
	private static final String Password="Admin001";
	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	  //create new course
		public Course newCourse(String courseName, String courseID, int maxStudents, String instructor,
				int courseSection, String courseLocation, ArrayList<Course> courseArr) {
		   Course tempcourse = new Course(courseName, courseID, maxStudents, 0,
					instructor, courseSection, courseLocation);
		   courseArr.add(tempcourse);
		   return tempcourse;
		};
		
		//delete course
		public void deleteCourse(ArrayList<Course> courseArr, String x) {
			for (int i = 0; i < courseArr.size(); i++) {

				//System.out.println(o.getCourse_Name());
				if (courseArr.get(i).getName().toLowerCase().equals(x.toLowerCase())) {
					
					courseArr.remove(courseArr.get(i));
					
				}
			}
			
			
		};
		
		//edit course
		public void editCourse(String courseName, int maxStudents, String instructor,
				int courseSection, String courseLocation, ArrayList<Course> courseArr) {
			
			for (int i=0; i<courseArr.size(); i++) {

				if (courseArr.get(i).getName().toLowerCase().equals(courseName.toLowerCase())) {
					courseArr.get(i).setMaxNum(maxStudents);
					courseArr.get(i).setInstructor(instructor);
					courseArr.get(i).setSectionNum(courseSection);
					courseArr.get(i).setLocation(courseLocation);					
				}
			}
			
			
		};
		
		
		//display course info(By ID)
		public void displayCourse(String courseID, ArrayList <Course> x) {
				for (int i = 0; i < x.size(); i++) {
				
				Course temp = x.get(i);

				if (temp.getId().toLowerCase().equals(courseID.toLowerCase())) {
					
					System.out.println("This is the information for Course: " + temp.getId());

					System.out.println("\tCourse name: " + temp.getName());
					System.out.println("\tCourse location: " + temp.getLocation());
					System.out.println("\tCourse section: " + temp.getSectionNum());
					
					System.out.println("\tCourse Instructor: " +temp.getInstructor());
					System.out.println("\tCurrent Number of Students: " +temp.getCurStudentNum());
					System.out.println("\tMaximum Students: " +temp.getMaxNum());
					
					System.out.println("\tStudent Names: ");
					
					if(temp.getStudentList()!=null) {
						for (Student names: temp.getStudentList()) {
							System.out.println("/t"+names.getFirstname() + " " + names.getLastname());
						}
					}else {
						System.out.println("\t\tNone");
					}
					
					
					
				}
			}
			
			
		};
		
		//Register student
		public void registerStudent(ArrayList<Student> students, String firstname, String lastname) {
			Random rand = new Random();

			String username = Character.toString(firstname.charAt(0)).toLowerCase()+Character.toString(lastname.charAt(0)).toLowerCase()+rand.nextInt(9)
							  +rand.nextInt(9)+rand.nextInt(9)+rand.nextInt(9);
			
			String password =  Character.toString((char)(rand.nextInt(26) + 'a'))+Character.toString((char)(rand.nextInt(26) + 'a'))+rand.nextInt(9)+rand.nextInt(9)+rand.nextInt(9) ;
			
			Student student = new Student(username,  password,firstname,lastname);
			students.add(student);
	
			System.out.println("New Student registered: [name:" + firstname+" "+lastname+"]"+"[username:"+username+"]"+"[password:"+password+"]");

			
			
		};
		
		//View all courses that are full 
		public void viewFullCourses(ArrayList<Course> x) {
			
			System.out.print("Courses that are full: ");
			int cnt=0;

			
			for (int i = 0; i<x.size(); i++) {
				Course temp = x.get(i);
				
				if (temp.getCurStudentNum() == temp.getMaxNum() ) {

					System.out.println(temp.getName());
					cnt++;
					
				}
				
				
			}
			
			if (cnt==0) {
				System.out.println("None");
			}else {
				System.out.println(cnt+" full courses");
			}
			
		};
		
		//write to file the list of courses that are full
		public void writeToFile(ArrayList<Course> x) throws FileNotFoundException, UnsupportedEncodingException {
	
			PrintWriter writer = new PrintWriter ("Courses_that_are_full.txt", "UTF-8");
			for (int i=0; i<x.size();i++) {

				Course temp = x.get(i);
				
				
				if (temp.getCurStudentNum() == temp.getMaxNum()) {
					writer.println(temp.getName());				
					}
			
			}
				writer.close();
			}


		
		
		//view names of students being registered in a specific course
		public void viewRegisteredStudents(ArrayList <Course> x, String course) {
			System.out.println("Students registered in this course:");
			int cnt=0;
			
			for (int i = 0; i < x.size(); i ++) {
				Course temp = x.get(i);
				
				
				if (temp.getName().toLowerCase().equals(course.toLowerCase())) {
					
					ArrayList<Student> students = temp.getStudentList();
					
					if(temp.getStudentList()!=null) {
						for (Student s: students) {
							System.out.println("\t"+s.getFirstname() + " " + s.getLastname());
							cnt++;
						}
						
					}
					
			}
			}
			
			if (cnt==0) {
				System.out.println("\tNone");
			}else {
				System.out.println("\t"+cnt+" students in total");
			}
			
		};
		
		
		//sort courses based on current no. of student registers 
		public void Sort(ArrayList<Course>  x) {
			
			
			ArrayList<Integer>  list = new ArrayList<Integer>();
			ArrayList<Course> list2 = new ArrayList<Course>();

			
			for (int i=0 ; i<x.size();i++){

				list.add(x.get(i).getCurStudentNum());
				list2.add(x.get(i));		
			}
			
			Collections.sort(list);
			
			System.out.println("Courses sorted based on the number of registered students, in ascending order:");
			
			
			for (int y:list) {
				for (int i=0;  i<list2.size();i++) {

					if (list2.get(i).getCurStudentNum() ==y ) {
						
						System.out.println(list2.get(i).getName() + ":  " + list2.get(i).getCurStudentNum() + " students" );
						list2.remove(list2.get(i));
					}
				}
			}
		}
		
		//View courses a specific student is registered in 
		public void viewStudentCourse(String Firstname, String Lastname, ArrayList<Student> x) {
			   System.out.println("This student is registered in :");
			
				for (Student s : x) {
				
				if (s.getFirstname().toLowerCase().equals(Firstname.toLowerCase()) && s.getLastname().toLowerCase().equals(Lastname.toLowerCase())) {
					for(Course c:s.getCourses()) {
						System.out.println("\t"+c.getName());
					}
					
				}
					
					
			}
			
		}
		
		@Override
		public void viewStudentCourse() {
			// TODO Auto-generated method stub
			
		}
		
	
		
		//Course Management Option menu
	
		public void courseManagementInstructions() {
			System.out.println("1. Create new Course.");
			System.out.println("2. Delete Course.");
			System.out.println("3. Edit Course.");
			System.out.println("4. Display information for a given course.");
			System.out.println("5. Register a student.");
			System.out.println("6. Exit.");


		}
		
		//Reports Option menu
		public void reportsInstructions() {
			System.out.println("1. View all courses.");
			System.out.println("2. View all courses that are FULL.");
			System.out.println("3. Write to a file the list of course that are FULL.");
			System.out.println("4. View the names of the students being registered in a specific course");
			System.out.println("5. View the list of courses that a given student is registered on.");
			System.out.println("6. Sort courses based on the current number of student registers.");
			System.out.println("7. Exit.");
			
		}

		
	



}
