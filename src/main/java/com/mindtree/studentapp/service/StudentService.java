package com.mindtree.studentapp.service;

import com.mindtree.studentapp.entity.Classroom;
import com.mindtree.studentapp.entity.Student;
import com.mindtree.studentapp.exceptions.InvalidInputException;

public interface StudentService {
	void addClassroom(Classroom classroom);
	void addStudent(Student student,int classId);
	Student getStudent(int id)throws InvalidInputException;
	Student updateStudent(int age,int id)throws InvalidInputException;

}
