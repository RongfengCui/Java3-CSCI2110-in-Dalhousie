package com.cui.csci2110.lab4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class StudentListDemo {
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		StudentList students = new StudentList();
		int studentID; String firstName; String lastName; String email; String major; String faculty;
		Student stu=null;
		
		while (inputFile.hasNext())
		{
			studentID = inputFile.nextInt();
			firstName = inputFile.next();
			lastName = inputFile.next();
			email = inputFile.next();
			major = inputFile.next();
			faculty = inputFile.next();
			stu = new Student(studentID, firstName, lastName, email, major, faculty);
			students.addToEnd(stu); //put each student object to the file
		}
		inputFile.close();		
		students.searchName("John", "Mclain");
	}
}
