package com.bmo.alerts.bs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee2")
public class Employee implements Serializable {
	
	
	
public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
private static final long serialVersionUID = 1L;
@Id
@Column(name="id")
@GeneratedValue
	private int id;
	private String name;
	private String dept;
	private double salary;
	
	public Employee(String name, String dept, double salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	public Employee(int id, String name, String dept, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
