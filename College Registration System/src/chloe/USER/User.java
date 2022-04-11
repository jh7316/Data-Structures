package chloe.USER;

import java.io.Serializable;
import java.util.ArrayList;

import chloe.COURSEDATA.Course;

public abstract class User implements Serializable{
	//private static final long serialVersionUID = -4975041306456139842L;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	public User() {
		
	}
	
	//constructor
	public User(String username, String password, String firstname, String lastname) {
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
	}
	
	
	
	//Getters and setters 
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	//View All courses
	public static void viewAllCourses(ArrayList<Course> x) {
		for (int i = 0; i < x.size(); i++) {		
			System.out.println(x.get(i).getName());
		}
	}
	
	
	//View courses a specific student is registered in(abstract method) 
	public abstract void viewStudentCourse();
	
}
	


