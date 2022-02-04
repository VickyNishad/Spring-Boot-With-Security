package com.student.details;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDetails {
	
	@Id
	private long id;
	private long roll;
	private String name;
	private String collage;
	public StudentDetails(long id, long roll, String name, String collage) {
		super();
		this.id = id;
		this.roll = roll;
		this.name = name;
		this.collage = collage;
	}
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRoll() {
		return roll;
	}
	public void setRoll(long roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollage() {
		return collage;
	}
	public void setCollage(String collage) {
		this.collage = collage;
	}
	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", roll=" + roll + ", name=" + name + ", collage=" + collage + "]";
	}
	
	
	
	
}
	
	
