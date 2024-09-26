package com.deloitte.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String firstName;

	@Column(name = "salary")
	private double salary;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Employee() {
		super();
	}

	public Employee(String firstName, double salary) {
		super();
		this.firstName = firstName;
		this.salary = salary;
	}

	public Employee(int id, String firstName, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", salary=" + salary + "]";
	}
}
