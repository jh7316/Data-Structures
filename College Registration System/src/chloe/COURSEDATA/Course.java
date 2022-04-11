package chloe.COURSEDATA;

import java.io.Serializable;
import java.util.ArrayList;

import chloe.USER.Student;

public class Course implements Serializable {
	//private static final long serialVersionUID = -4975041306456139842L;
	
	//variables for the course: 
	private String name;
	private String id;
	private int maxNum;
	
	//number of current students is set as 0 as default
	private int curStudentNum=0;
	ArrayList<Student> studentList=new ArrayList<>();
	private String instructor;
	private int sectionNum;
	private String location;
	
	
	//constructor
	public Course(String name, String id, int maxNum, int curStudentNum,
			String instructor, int sectionNum, String location) {
		this.name = name;
		this.id = id;
		this.maxNum = maxNum;
		this.curStudentNum = curStudentNum;
		this.instructor = instructor;
		this.sectionNum = sectionNum;
		this.location = location;
	}
	
	public Course() {
		
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public int getCurStudentNum() {
		return curStudentNum;
	}

	public void setCurStudentNum(int curStudentNum) {
		this.curStudentNum = curStudentNum;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
	//Method
	
	
	
	//method for adding Student into the course
	public void addStudent(Student sname) {

		if (this.getCurStudentNum() < this.getMaxNum()) {
			
		studentList.add(sname);
		this.curStudentNum ++;

		System.out.println("You have sucessfully registered in the class.");
	
	   }else {		
			System.out.println("This course is full.");

		}
		

		
	}
	
	
	//method for deleting Student from the course 
	public void deleteStudent(Student sname) {
		studentList.remove(sname);
		this.curStudentNum --;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
