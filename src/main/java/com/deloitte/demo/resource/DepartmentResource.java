package com.deloitte.demo.resource;

import com.deloitte.demo.model.Department;
import com.deloitte.demo.repository.DepartmentRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/departments")
public class DepartmentResource {

	private DepartmentRepository departmentRepository = new DepartmentRepository();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addDepartment(Department department) {
		departmentRepository.addDepartment(department);
		return Response.status(Response.Status.CREATED).entity(department).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> getAllDepartments() {
		return departmentRepository.getAllDepartments();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDepartmentById(@PathParam("id") int id) {
		Department department = departmentRepository.getDepartmentById(id);
		if (department != null) {
			return Response.ok(department).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDepartment(@PathParam("id") int id, Department department) {
		department.setId(id);
		departmentRepository.updateDepartment(department);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteDepartment(@PathParam("id") int id) {
		Department existingDepartment = departmentRepository.getDepartmentById(id);
		if (existingDepartment == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		departmentRepository.deleteDepartment(id);
		return Response.noContent().build();
	}
}
