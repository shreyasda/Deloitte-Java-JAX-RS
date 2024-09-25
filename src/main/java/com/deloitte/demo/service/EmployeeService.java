package com.deloitte.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.deloitte.demo.model.Employee;

public class EmployeeService {
	private static EmployeeService instance;

	private EmployeeService() {
		empList = new ArrayList<>(List.of(new Employee(1, "Sonu", 90.25), new Employee(2, "Monu", 95.75),
				new Employee(3, "Tonu", 92.25)));
	}

	public static EmployeeService getInstance() {
		if (instance == null) {
			synchronized (EmployeeService.class) {
				if (instance == null) {
					instance = new EmployeeService();
				}
			}
		}
		return instance;
	}

	private List<Employee> empList;

	public List<Employee> getAllEmployees() {
		empList.forEach(System.out::println);
		return empList;
	}

	public Employee getEmployeeById(int id) {
		return empList.stream().filter(emp -> emp.getId() == id).findFirst().orElse(null);
	}

	public void addEmployee(Employee employee) {
		empList.add(employee);
	}

	public boolean updateEmployee(int id, Employee updatedEmployee) {
		for (int i = 0; i < empList.size(); i++) {
			Employee emp = empList.get(i);
			if (emp.getId() == id) {
				empList.set(i, updatedEmployee);
				return true;
			}
		}
		return false;
	}

	public boolean deleteEmployee(int id) {
		return empList.removeIf(emp -> emp.getId() == id);
	}
}
