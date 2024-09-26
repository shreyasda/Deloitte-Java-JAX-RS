package com.deloitte.demo.resource;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.deloitte.demo.model.Employee;
import com.deloitte.demo.service.EmployeeService;

@Path("/employees")
public class EmployeeResource {
	private EmployeeService employeeService = new EmployeeService();

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
	public Employee addEmployee(Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("id") int id, Employee updatedEmployee) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		if (existingEmployee == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
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
