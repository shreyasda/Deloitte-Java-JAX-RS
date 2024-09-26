package com.deloitte.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import com.deloitte.demo.model.Department;

public class DepartmentRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePU");

    public Department addDepartment(Department department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            department = entityManager.merge(department); 
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace(); 
        } finally {
            entityManager.close(); 
        }
        return department;
    }

    public List<Department> getAllDepartments() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Department> departments = entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        entityManager.close();
        return departments;
    }

    public Department getDepartmentById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Department department = entityManager.find(Department.class, id);
        entityManager.close();
        return department;
    }

    public void updateDepartment(Department department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(department);
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

    public void deleteDepartment(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Department department = entityManager.find(Department.class, id);
            if (department != null) {
                entityManager.remove(department);
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
