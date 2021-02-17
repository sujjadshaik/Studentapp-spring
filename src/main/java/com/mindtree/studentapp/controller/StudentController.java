package com.mindtree.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.studentapp.entity.Classroom;
import com.mindtree.studentapp.entity.Student;
import com.mindtree.studentapp.exceptions.InvalidInputException;
import com.mindtree.studentapp.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("classroom")
	public ResponseEntity addClassRoom(@RequestBody Classroom classroom) {
		service.addClassroom(classroom);
		return new ResponseEntity<>("Class added", HttpStatus.OK);
	}

	@PostMapping("student/{id}")
	public ResponseEntity addStudent(@RequestBody Student student, @PathVariable("id") int id) {
		service.addStudent(student, id);
		return new ResponseEntity<>("student added to class with id" + id, HttpStatus.OK);

	}

	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
		Student student;
		try {
			student = service.getStudent(id);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity("Id not found", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PutMapping("student/{id}")
	public ResponseEntity updateAge(@RequestBody int age, @PathVariable("id") int id) {
		try {
			service.updateStudent(age, id);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Student age updated", HttpStatus.OK);
	}

}
