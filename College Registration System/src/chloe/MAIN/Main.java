package chloe.MAIN;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import chloe.COURSEDATA.Course;
import chloe.COURSEDATA.Data;
import chloe.USER.Admin;
import chloe.USER.Student;


public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		//create array lists that will contain whole courses and students 
		ArrayList <Course> CourseArray = new ArrayList<Course>();
		ArrayList<Student> students = new ArrayList<Student>();
		
		
		
		
		System.out.println("Welcome! Is this your first time using this Course Registration System?(y/n)");
		String answer = sc.nextLine().toLowerCase();
		
		//repeats getting values from user until the user enters a valid value
		while( !answer.equals("y") && !answer.equals("n")) {
			System.out.println("Invalid answer.Please enter 'y' for Yes or 'n' for No.");
			String answer2 = sc.nextLine().toLowerCase();
			answer = answer2;	
		}
		
		
		
		
		if (answer.equals("y")) {
			//if answer is yes, it is the first time using the system, so reset the CourseArray with default courses 
			CourseArray = Data.DataToArr();
			students = new ArrayList<Student>();

		}else {
			//if answer is no, there exists data for modified courses and students stored by serialization, so deserialize to call the data 
			
			//deserialization 
			try{
				  //receive data as bytes from a file
			      FileInputStream fis = new FileInputStream("CourseArray.ser");
			      
			      FileInputStream fis2 = new FileInputStream("Student.ser");

			      
			      
			      // reconstruct byte data into an object
			      ObjectInputStream ois = new ObjectInputStream(fis);
			      
			      
			      ObjectInputStream ois2 = new ObjectInputStream(fis2);
			      CourseArray = (ArrayList<Course>)ois.readObject();
			      students = (ArrayList<Student>)ois2.readObject();
			      

			      ois.close();
			      fis.close();
			      
			      ois2.close();
			      fis2.close();
			    }
			    catch(IOException ioe) {
			       ioe.printStackTrace();
			       return;
			    }
			 catch(ClassNotFoundException cnfe) {
			       cnfe.printStackTrace();
			       return;
			     }
			
			
			
		}
		

		//boolean variable that repeats the registration system until the user exits
		boolean w = true;
		
		
		while (w) {
		
		
		
		System.out.println("This is the Course Registration System. If you are a student, enter 's', or 'a' if you are an admin.");
		
		String s = sc.nextLine().toLowerCase();
		
		//keeps asking for input until user enters a valid input
		while (!s.equals("s") && !s.equals("a") ) {
			
			System.out.println("This is not a valid answer. Please enter 'a' for admin or 's' for student .");
			String s1 = sc.nextLine();

			s = s1;
			
		}
				
		
		//boolean variable that repeats the admin system until the admin exits 
		boolean h = true;
		if (s.equals("a")) {
			
			System.out.println("Enter username:");
			
			String username = sc.nextLine();
			
			
			//login password: checks if the username and password is correct 
			while (!username.equals("Admin")) {
				
				System.out.println("That is an incorrect username.");
				System.out.println("Please Enter a Username:");

				String username1 = sc.nextLine();
				username = username1;
				

			}
			
			System.out.println("Enter password:");
			
			String password = sc.nextLine();

			while (!password.equals("Admin001")) {
				
				System.out.println("That is an incorrect password.");
				System.out.println("Please Enter a Password:");

				String password1 = sc.nextLine();
				
				password = password1;
				
				

			}
			
			//creates new admin object 
			Admin ad = new Admin();
			
			
			while (h) {

			System.out.println("Successfully logged in. Would you like to operate Course Management or Reports?:");
			
			System.out.println("For Course Management, enter 'c'. For Reports, enter 'r'.");
			
			String m = sc.nextLine();

			
			
			while (!m.equals("c") && !m.equals("r")) {
				
				System.out.println("This is not a valid key.");
				System.out.println("For Course Management, enter 'c'. For Reports, enter 'r'.");
				
				
				String m1 = sc.nextLine();
				m = m1;
				
			}
			
			
			if (m.equals("c")) {
				
				ad.courseManagementInstructions();
				
				System.out.println("Enter the number of the option you would like to execute.");
				String num = sc.nextLine();
				
				while (!num.equals("1") && !num.equals("2") &&!num.equals("3") &&!num.equals("4") && !num.equals("5") && !num.equals("6")) {
					System.out.println("This is not a valid number.Please enter a number between 1 and 6.");
					String num1 = sc.nextLine();
					
					num = num1;
					
				}
				
				//Create new course 
				if (num.equals("1")) {
					
					System.out.println("Enter a name of the new course.");
					String courseName = sc.nextLine();
					
					
					System.out.println("Enter a course ID.");
					String courseId = sc.nextLine();
					
					System.out.println("Enter the maximum number of students.");
					String maxStudents=sc.nextLine();
					//Try-catch process makes sure the user enters a number for maximum number of students(same for section num)
					boolean bo=false;
					while(bo==false) {
						try {  
						    Integer.parseInt(maxStudents);  
						    bo=true;
						    break;
						  } catch(NumberFormatException e){  
						    bo=false;  
						  } 
						System.out.println("Invalid value. Enter again.");
						String maxStudents2=sc.nextLine();
						maxStudents=maxStudents2;
						
					}
					int maxStudents3 = Integer.parseInt(maxStudents);
					

					System.out.println("Enter a name of the instructor.");
					String instructor = sc.nextLine();
					
					
					System.out.println("Enter the course section.");
					String section=sc.nextLine();
					boolean bo1=false;
					while(bo1==false) {
						try {  
						    Integer.parseInt(section);  
						    bo1=true;
						    break;
						  } catch(NumberFormatException e){  
						    bo1=false;  
						  } 
						System.out.println("Invalid value. Enter again.");
						String section2=sc.nextLine();
						section=section2;
						
					}
					int section3 = Integer.parseInt(section);
					
					
					
					System.out.println("Enter the course location.");
					String location = sc.nextLine();


					
					ad.newCourse(courseName, courseId, maxStudents3, instructor, section3, location, CourseArray);
					System.out.println("New course created.");
					
					
				}
				
				//Delete course 
				if (num.equals("2")){
					
					System.out.println("Enter the name of the course you would like to delete.");
					String courseName1 = sc.nextLine();
					

					ad.deleteCourse(CourseArray, courseName1);
					System.out.println("Course deleted.");
					
				}
				
				//Edit course
				if (num.equals("3")){
					
					
					System.out.println("Enter name of the course you would like to edit.");
					String courseName2 = sc.nextLine();
					
					System.out.println("Enter the following information of the courses including the changes you want to make.");
					
					System.out.println("Maximum number of students:");
					String x1=sc.nextLine();
					//Try-catch process to make sure the user enters a number value for maximum number of students 
					boolean bo2=false;
					while(bo2==false) {
						try {  
						    Integer.parseInt(x1);  
						    bo2=true;
						    break;
						  } catch(NumberFormatException e){  
						    bo2=false;  
						  } 
						System.out.println("Invalid value. Enter again.");
						String x11=sc.nextLine();
						x1=x11;
						
					}
					int x12 = Integer.parseInt(x1);
					
					
					System.out.println("Instructor name:");
					String x2=sc.nextLine();
					System.out.println("Course Section:");
					String x3=sc.nextLine();
					boolean bo3=false;
					while(bo3==false) {
						try {  
						    Integer.parseInt(x3);  
						    bo3=true;
						    break;
						  } catch(NumberFormatException e){  
						    bo3=false;  
						  } 
						System.out.println("Invalid value. Enter again.");
						String x31=sc.nextLine();
						x3=x31;
						
					}
					int x32 = Integer.parseInt(x3);
					
					System.out.println("Course Location:");
					String x4=sc.nextLine();
					


					ad.editCourse(courseName2 , x12,x2,x32,x4, CourseArray);
					
				}
				
				//Display information for a given course
				if (num.equals("4")){
					
					System.out.println("Please enter the ID of the course you would like to view.");
					String courseID = sc.nextLine();
					ad.displayCourse(courseID,CourseArray);
					
					
				}
				
				//Register student(adds a student object to the students array list)
				if (num.equals("5")) {
					
					System.out.println("Enter the first name of the student");
					String f = sc.nextLine();
					System.out.println("Enter the last name of the student");
					String l = sc.nextLine();
					
					ad.registerStudent(students, f,l);

					
					
				}
				
				//Exit
				if (num.equals("6")) {
					w = false;
					h = false;
					

					//serialization - stores the modified data before ending the program 
					
					try {
						//write data to a file
						FileOutputStream CourseArray_Data = new FileOutputStream("CourseArray.ser");
						
						
						FileOutputStream student_Data = new FileOutputStream("Student.ser");

						//write objects to a stream 
						ObjectOutputStream oos = new ObjectOutputStream(CourseArray_Data);
						
						ObjectOutputStream oos2 = new ObjectOutputStream(student_Data);

						
						//Writes the object to the object output streams
						
						oos2.writeObject(students);

						oos.writeObject(CourseArray);
						

						
						//Close the output streams
						oos.close();
						oos2.close();

						CourseArray_Data.close();
						
						student_Data.close();

						System.out.println("All your information has been updated.");
					} 
					catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
			
			//Reports
			else {
				ad.reportsInstructions();
				
				System.out.println("Enter the number of the option you would like to execute.");
				String num = sc.nextLine();
				
				while (!num.equals("1") && !num.equals("2") &&!num.equals("3") &&!num.equals("4") && !num.equals("5") && !num.equals("6")&& !num.equals("7")) {
					System.out.println("This is not a valid number.Please enter a number between 1 and 7.");
					String num1 = sc.nextLine();
					
					num = num1;
					
				}
				
				
				//View all courses
				if (num.equals("1")) {
					ad.viewAllCourses(CourseArray);
					
					
				}
			
		
				//view all courses thar are full 
				if (num.equals("2")) {
					ad.viewFullCourses(CourseArray);
				}
		
			
			
		
				//Write to a file the list of course that are full 
				if (num.equals("3")) {
					
					ad.writeToFile(CourseArray);
					System.out.println("File created.");

				}
					
				
				//View the names of the students being registered in a specific course
				if (num.equals("4")) {
					
					System.out.println("Enter the name of the course you would like to see the students of.");			
					String courseName = sc.nextLine();
	
					ad.viewRegisteredStudents(CourseArray, courseName);
				}
				
				//View the list of courses that a given student is being registered on
				if (num.equals("5")) {
					
					System.out.println("Enter the student's first name");
					String f = sc.nextLine();
					
					
					System.out.println("Enter the student's last name");
					String l= sc.nextLine();

					
					ad.viewStudentCourse(f, l, students);
					

}
				
				//Sort courses based on the current number of student registers
				
				if (num.equals("6")) {
					ad.Sort(CourseArray);
					
					
					
					
				}

				//Exit
				if (num.equals("7")) {
					
					w = false;
					h = false;
					

					//serialization 
					
					try {
						//write data to a file
						FileOutputStream CourseArray_Data = new FileOutputStream("CourseArray.ser");
						
						
						FileOutputStream student_Data = new FileOutputStream("Student.ser");

						//write objects to a stream 
						ObjectOutputStream oos = new ObjectOutputStream(CourseArray_Data);
						
						ObjectOutputStream oos2 = new ObjectOutputStream(student_Data);

						
						//Writes the object to the object output streams
						
						oos2.writeObject(students);

						oos.writeObject(CourseArray);
						

						
						//Close the output streams
						oos.close();
						oos2.close();

						CourseArray_Data.close();
						
						student_Data.close();

						System.out.println("All your information has been updated.");
					} 
					catch (IOException ioe) {
						ioe.printStackTrace();
					}
	
				}
				
			}
}
			
		}
		
		
		//boolean variable to repeat the student program until the student exits 
		boolean f = true;
		
		
		//Case for student
		if (s.equals("s")) {
			
			boolean c = true;
			Student currentStudent = new Student();
			
			//checks if the entered username is in the student list
			while (c){
				System.out.println("Enter username.");
				String username1 = sc.nextLine();
				for (Student s11: students) {
					
					String username2 = s11.getUsername();
					if (username1.equals(username2)) {
						currentStudent=s11;
						c = false;	
					}
				}
				
				if (c) {
				System.out.println("Student with this username does not exist in the system. Please enter again.");
					}
			}
				
			//checks if the password is correct by comparing it with the specified student's password 
			while (!c) {
				System.out.println("Enter password.");
				String password1 = sc.nextLine();

					String password2 = currentStudent.getPassword();
					if (password1.equals(password2)) {
						c = true;
					}
				
				
				if (c == false) {
				System.out.println("Incorrect password. Please enter again.");
					}
			
			}
			
			while (f) {
			currentStudent.studentCourseManagementInstructions();	
			String num = sc.nextLine();
			
			
			

			while (!num.equals("1") && !num.equals("2") &&!num.equals("3") &&!num.equals("4") && !num.equals("5") && !num.equals("6")) {
				System.out.println("This is not a valid number.Please enter a number between 1 and 6.");
				String num1 = sc.nextLine();
				
				num = num1;
				
			}
			
			
			//View all courses
			if (num.equals("1")) {
				currentStudent.viewAllCourses(CourseArray);
			}
		
			
			//View all courses that are not FULL
			if (num.equals("2")) {
				currentStudent.viewCoursesNotFull(CourseArray);
				
				
			}
		
			//Register on a course 
			if (num.equals("3")) {
				
				System.out.println("Enter the course name.");
				String courseName = sc.nextLine();
				
				System.out.println("Enter the course section.");
				String section = sc.nextLine();
				
				currentStudent.registerCourse(currentStudent, CourseArray, courseName, Integer.parseInt(section));
				
				
				
			}
			
			//Withdraw from a course
			if (num.equals("4")) {
				
				System.out.println("Enter the course name.");
				String courseName = sc.nextLine();
				
				System.out.println("Enter the course section.");
				String section = sc.nextLine();
				
				
				currentStudent.withdrawCourse(CourseArray, currentStudent, courseName, Integer.parseInt(section));
		
			}
			
			//View all courses that the current student is being registered in
			if (num.equals("5")) {
				
				
				currentStudent.viewStudentCourse();
		

			}
			
			
			//Exit
			if (num.equals("6")) {
				w = false;
				f = false;
				
				//serialization 
				
				try {
					//write data to a file
					FileOutputStream CourseArray_Data = new FileOutputStream("CourseArray.ser");
					
					
					FileOutputStream student_Data = new FileOutputStream("Student.ser");

					//write objects to a stream 
					ObjectOutputStream oos = new ObjectOutputStream(CourseArray_Data);
					
					ObjectOutputStream oos2 = new ObjectOutputStream(student_Data);

					
					//Writes the object to the object output streams
					
					oos2.writeObject(students);

					oos.writeObject(CourseArray);
					

					
					//Close the output streams
					oos.close();
					oos2.close();

					CourseArray_Data.close();
					
					student_Data.close();

					System.out.println("All your information has been updated.");
				} 
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
				
				

			
			
			
			
		}
		
		
		
	}
		
		
		
}
		
		
		
		
		
		
		
	}

}
