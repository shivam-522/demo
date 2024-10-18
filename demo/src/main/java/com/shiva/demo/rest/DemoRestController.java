package com.shiva.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class DemoRestController {

	private List<Student> theStudent=new ArrayList<>();
	
	
	@PostConstruct  //annotation is used on a method that needs to be executed after dependency injection is done to perform any initialization. This  method must be invoked before the class is put into service.
	public void loadData()
	{
		//theStudent=new ArrayList<>();
		theStudent.add(new Student("Shivam","Samadhiya"));
		theStudent.add(new Student("Akash","ambani"));
		theStudent.add(new Student("narendra","yadav"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return theStudent;
	}
	
	//define endpoint or /students/{studentId} --return student student present at this index
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId)
	{
		//just index into list 
		
		//check the student id against the  list size
		
		if((studentId>=theStudent.size()) || (studentId<0))
		{
			throw new StudentNotFoundException("Student id is not found -- "+studentId);
		}
		
		return theStudent.get(studentId);
	}
	
	
	
	//add Exception handler using @ExceptionHandler
	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc){
//		
//		//Create a StudentErrorResponse
//		StudentErrorResponse error=new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		//Return ResponseEntity
//		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//	}
//	
//	//add another exception handler to catch any type of exception (Catch all)
//	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception e)
//	{
//StudentErrorResponse error=new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(e.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		//Return ResponseEntity
//		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
