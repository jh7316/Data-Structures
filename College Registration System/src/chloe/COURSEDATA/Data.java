package chloe.COURSEDATA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Data {
	
	//One big method that organizes the Course information to one Arraylist of Course objects 
	public static ArrayList<Course> DataToArr() throws FileNotFoundException{
		String ln="";
		Scanner s=new Scanner(new File("/Users/chloejuhee/eclipse-workspace/Han_HW1/src/chloe/COURSEDATA/MyUniversityCoursesFile.csv"));
		
		
		//Goes over each line of the file
		while (s.hasNextLine()) {
			
			String templine = s.nextLine();
			
			ln += templine + "/";

				
			}
			
		s.close();
		
		//Divides each line and stores them into arrays, one line contains information for one course 
		String[] arr=ln.split("/");
		int cnt=arr.length;
		String[][] arr2=new String[arr.length][8];
		
		cnt=0;
		
		//Splits sections of information contained in one line, each section represents one attribute like name, id, section
		for(String x:arr) {
			
			int cnt2=0;
			String[] arr3=x.split(",");
			
			//Skips the first line
			if(!arr3[0].equals("Course_Name")) {
				for(int i=0;i<arr3.length;i++) {
					arr2[cnt][cnt2]=arr3[i];
					cnt2++;
					
				}
				cnt++;
				
			}
			
		}
		
		
		//List that will contain the course objects 
		ArrayList <Course> CourseList = new ArrayList();
		

		
		//Assigns the values to the attributes of each course object 
		for(int i=0; i<arr2.length-1; i++) {
			Course tempCourse = new Course();
			tempCourse.setName(arr2[i][0]);
			tempCourse.setId(arr2[i][1]);
			
			
			int MaxnumInt = Integer.parseInt(arr2[i][2]);
			int CurStudentInt = Integer.parseInt(arr2[i][3]);
			int SectionNumInt = Integer.parseInt(arr2[i][6]);
			
			
			tempCourse.setMaxNum(MaxnumInt);
			tempCourse.setCurStudentNum(CurStudentInt);
			tempCourse.setStudentList(null);
			tempCourse.setInstructor(arr2[i][5]);
			tempCourse.setSectionNum(SectionNumInt);
			tempCourse.setLocation(arr2[i][7]);
			
			CourseList.add(tempCourse);
			
		
		
		
	
		
	}
		//returns the final list
		return CourseList;
	
	
	
	
	
	
	
	}
	
	/*
	public static void main(String[] args) throws IOException {
		ArrayList<Course> temparray=DataToArr();
		for(Course x:temparray) {
			System.out.println(x.getName()+"//"+x.getId()+"//"+x.getMaxNum()
			+"//"+x.getCurStudentNum()+"//"+x.getInstructor()+"//"+x.getSectionNum()+"//"+x.getLocation());
		}
	
	}
	*/
}
