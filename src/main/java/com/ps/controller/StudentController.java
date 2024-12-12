package com.ps.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ps.Entity.student;
import com.ps.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;
	//get all the students
	@GetMapping("/students")
	public List<student>getAllStudents(){
		List<student> students = repo.findAll();
		
		return students;
	}
	
	@GetMapping("/students/{id}")
	public student  getStudent(@PathVariable int id) {
		student student = repo.findById(id).get();
		return student;
		
		
	}
	
	@PostMapping("/student/add")
	@ResponseStatus(code= HttpStatus.CREATED)
	public void createstudent(@RequestBody student student) {
		repo.save(student);
		
	}
	
	@PutMapping("/student/update/{id}")
	public student updateStudents(@PathVariable int id) {
		student student = repo.findById(id).get();
		student.setName("poonam");
		student.setPercentage(90);
		repo.save(student);
		return student;
		
	}
	@DeleteMapping("/student/delete/{id}")
	public void  removeStudent(@PathVariable int id) {
	    student student = repo.findById(id).get();
	    repo.delete(student);
	}

}
