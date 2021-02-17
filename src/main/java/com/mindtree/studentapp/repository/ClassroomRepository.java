package com.mindtree.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.studentapp.entity.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer>{
	public Classroom findById(int id);
}
