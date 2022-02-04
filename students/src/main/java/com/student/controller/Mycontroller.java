package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.details.StudentDetails;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class Mycontroller {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/students")
	public List<StudentDetails> getDetails()
	{
	    return	this.studentService.getDetails();
	}
	

	// post method
	@PostMapping("/students")
	public StudentDetails addStudentDetails(@RequestBody StudentDetails details)
	{
		return this.studentService.addStudentDetails(details);
	}
	
	
	// sorting by field
	
	@GetMapping("/{field}")
	public List<StudentDetails> getdetailsWithSorting(@PathVariable String field){
		List<StudentDetails> allDetails = this.studentService.finddetailsWithSorting(field);
		return allDetails;
	}
	
	// get course by pagenation
	
	@GetMapping("/{offset}/{pagesize}")
	public Page<StudentDetails> findByPagenation(@PathVariable int offset , @PathVariable int pagesize)
	
	{
		return this.studentService.finddetailsByPagenation(offset , pagesize);
	}
	
	@GetMapping("/{offset}/{pagesize}/{field}")
	public Page<StudentDetails> findPagenationAndSort(@PathVariable int offset , @PathVariable int pagesize , @PathVariable String field)
	{
		return this.studentService.findDetailsByPagenationAndSorting(offset , pagesize , field);
	}
	
	// single student details
	@GetMapping("/students/{id}")
	public Optional<StudentDetails> getStudent(@PathVariable String id)
	{
		return this.studentService.getStudent(Long.parseLong(id));
	}
	
	
	
	// put request 
	@PutMapping("/students/{id}")
	public StudentDetails updateDetails(@RequestBody StudentDetails details)
	
	{ 
		return this.studentService.updateDetails(details);
	}
	
	// delete method
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<HttpStatus> deleteDetails(@PathVariable String Id){
		try {
			this.studentService.deleteDetails(Long.parseLong(Id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
