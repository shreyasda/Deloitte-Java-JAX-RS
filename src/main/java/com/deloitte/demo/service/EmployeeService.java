package com.deloitte.demo.service;

import java.util.List;
import com.deloitte.demo.model.Employee;
import com.deloitte.demo.repository.EmployeeRepository;

public class EmployeeService {

	private EmployeeRepository employeeRepository = new EmployeeRepository();

	public Employee addEmployee(Employee employee) {
		if (employee == null) {
			throw new IllegalArgumentException("Employee cannot be null");
		}
		return employeeRepository.addEmployee(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

	public Employee getEmployeeById(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be greater than 0");
		}
		return employeeRepository.getEmployeeById(id);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.updateEmployee(employee);
	}

	public void deleteEmployee(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be greater than 0");
		}
		employeeRepository.deleteEmployee(id);
	}
}
