package com.kiranacodamy.restapiex;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController	
public class StudentController {
 
ArrayList<Student> arrayList =new ArrayList();

  StudentController()
 {
	 Student student =new Student (12,85,"ritesh");
	 Student student1 =new Student (13,90,"shruti");
	 Student student2 =new Student (14,80,"shekhar");
	  
	 arrayList.add(student);
	 arrayList.add(student1);
	 arrayList.add(student2);
 }
 
@GetMapping("students")
ArrayList allStudent()
{
	return arrayList;
	
}
@RequestMapping("student/{rollno}")
 public Student getStudent(@PathVariable int rollno) {
	 System.out.println(rollno);
	 for (Student student : arrayList) {
		if (student.rollno==rollno) 
			
		
			return student;
		
	 }
	 return null;
 
}
@PostMapping("student")
public ArrayList addStudent(@RequestBody Student student) {
	arrayList.add(student);
	return arrayList;
	 
}
@DeleteMapping("student/{rollno}")
public String  deleteStudent(@PathVariable int rollno) {
	for(Student student: arrayList) {
		if (student.rollno==rollno)
			arrayList.remove(student);	
	}
	return "record delete";
			
}
@PutMapping("student")
 public ArrayList updateStudent (@RequestBody Student clientStudent) {
	for(Student student :arrayList) {
		if(student.rollno==clientStudent.rollno) {
			student.setMarks(clientStudent.getMarks());
		}
	}
	 return arrayList;
}

}
