package chloe.INTERFACE;

import java.util.ArrayList;

import chloe.COURSEDATA.Course;
import chloe.USER.Student;

public interface StudentInterface {
	   //view courses that are not full
		public abstract void viewCoursesNotFull(ArrayList<Course> a);
		
		
		//withdraw from course
		public abstract void withdrawCourse(ArrayList <Course> a, Student x, String course, int section);
		
		
		//register course
		public abstract void registerCourse(Student s,  ArrayList <Course> x, String course, int section);

}
