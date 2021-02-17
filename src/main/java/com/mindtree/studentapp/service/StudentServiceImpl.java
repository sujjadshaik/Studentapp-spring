package com.mindtree.studentapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.studentapp.entity.Classroom;
import com.mindtree.studentapp.entity.Student;
import com.mindtree.studentapp.exceptions.InvalidInputException;
import com.mindtree.studentapp.repository.ClassroomRepository;
import com.mindtree.studentapp.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private ClassroomRepository classroomRepository;
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void addClassroom(Classroom classroom) {

		classroomRepository.save(classroom);

	}

	@Override
	public void addStudent(Student student, int classId) {
		// TODO Auto-generated method stub
		Classroom classroom = classroomRepository.findById(classId);
		student.setClassroom(classroom);
		studentRepository.save(student);

	}

	@Override
	public Student getStudent(int id) throws InvalidInputException{
		// TODO Auto-generated method stub
		try {
			studentRepository.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new InvalidInputException(e);
		}
		List<Student> student = new ArrayList<>();
		studentRepository.findAll().forEach(n -> student.add(n));
		for (Student s : student) {
			if (s.getId() == id)
				return s;
		}
		return null;

	}

	@Override
	public Student updateStudent(int age, int id) throws InvalidInputException {

		Student student;
		try {
			student = studentRepository.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new InvalidInputException(e);
		}
	
			
		student.setAge(age);
		studentRepository.save(student);
		return student;
	}

}
