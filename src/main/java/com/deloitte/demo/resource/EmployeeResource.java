package com.deloitte.demo.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deloitte.demo.model.Employee;
import com.deloitte.demo.service.EmployeeService;

@Path("/employees")
public class EmployeeResource {
	private EmployeeService empService = EmployeeService.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathParam("id") int id) {
		return empService.getEmployeeById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee employee) {
		empService.addEmployee(employee);
		return employee;
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("id") int id, Employee updatedEmployee) {
		boolean isUpdated = empService.updateEmployee(id, updatedEmployee);
		if (isUpdated) {
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEmployee(@PathParam("id") int id) {
		boolean isDeleted = empService.deleteEmployee(id);
		if (isDeleted) {
			return Response.noContent().build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
