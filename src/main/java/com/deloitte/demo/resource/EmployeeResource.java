package com.deloitte.demo.resource;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.deloitte.demo.model.Employee;
import com.deloitte.demo.model.Department;
import com.deloitte.demo.service.EmployeeService;
import com.deloitte.demo.service.DepartmentService;

@Path("/employees")
public class EmployeeResource {

	private EmployeeService employeeService = new EmployeeService();
	private DepartmentService departmentService = new DepartmentService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathParam("id") int id) {
		return employeeService.getEmployeeById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee employee) {
		if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
			Department department = departmentService.getDepartmentById(employee.getDepartment().getId());
			if (department == null) {
				return Response.status(Response.Status.BAD_REQUEST).entity("Invalid department ID").build();
			}
			employee.setDepartment(department);
		}

		Employee addedEmployee = employeeService.addEmployee(employee);
		return Response.status(Response.Status.CREATED).entity(addedEmployee).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("id") int id, Employee updatedEmployee) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		if (existingEmployee == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		if (updatedEmployee.getDepartment() != null && updatedEmployee.getDepartment().getId() != null) {
			Department department = departmentService.getDepartmentById(updatedEmployee.getDepartment().getId());
			if (department == null) {
				return Response.status(Response.Status.BAD_REQUEST).entity("Invalid department ID").build();
			}
			updatedEmployee.setDepartment(department);
		}

		updatedEmployee.setId(id);
		employeeService.updateEmployee(updatedEmployee);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEmployee(@PathParam("id") int id) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		if (existingEmployee == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		employeeService.deleteEmployee(id);
		return Response.noContent().build();
	}
}
