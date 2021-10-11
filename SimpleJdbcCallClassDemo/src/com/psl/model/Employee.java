package com.psl.model;

public class Employee {
	
	public Employee() {
		
	}
	
	public Employee(Integer id, String name, Float salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	private Integer id;
	private String name;
	private Float salary;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

}
