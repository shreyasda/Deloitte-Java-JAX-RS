package com.deloitte.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import com.deloitte.demo.model.Employee;

public class EmployeeRepository {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePU");

	public Employee addEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			if (employee.getDepartment() != null) {
				employee.setDepartment(entityManager.merge(employee.getDepartment()));
			}
			employee = entityManager.merge(employee);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return employee;
	}

	public List<Employee> getAllEmployees() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class)
				.getResultList();
		entityManager.close();
		return employees;
	}

	public Employee getEmployeeById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.close();
		return employee;
	}

	public void updateEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			if (employee.getDepartment() != null) {
				employee.setDepartment(entityManager.merge(employee.getDepartment()));
			}
			entityManager.merge(employee);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	public void deleteEmployee(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Employee employee = entityManager.find(Employee.class, id);
			if (employee != null) {
				entityManager.remove(employee);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}
}
