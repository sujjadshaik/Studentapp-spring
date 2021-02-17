package com.mindtree.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.studentapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
