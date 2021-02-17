package com.mindtree.studentapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Classroom {
	@Id
	private int id;
	private String name;
	private int strength;
	
	public Classroom() {
		// TODO Auto-generated constructor stub
	}

	public Classroom(int id, String name, int strength) {
		super();
		this.id = id;
		this.name = name;
		this.strength = strength;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	

}
