package com.miu.KafkaProject;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String title;
	private double salary;
	
	@JsonCreator
	public Employee(@JsonProperty("id") int  id, 
			@JsonProperty("name")String name, 
			@JsonProperty("title")String title, 
			@JsonProperty("salary")double salary) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.salary = salary;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
		
}
