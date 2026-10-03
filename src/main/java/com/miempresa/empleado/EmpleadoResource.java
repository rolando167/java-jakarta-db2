package com.miempresa.empleado;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/empleados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpleadoResource {

	@Inject
	private EmpleadoService empleadoService;

	@GET
	public List<EmpleadoDTO> listar() {
		return empleadoService.obtenerEmpleados();
	}

	@GET
	@Path("/{id}")
	public Response buscarPorId(@PathParam("id") Long id) {
		EmpleadoDTO dto = empleadoService.obtenerPorId(id);
		if (dto == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(dto).build();
	}

	@POST
	public Response crear(EmpleadoDTO dto) {
		EmpleadoDTO creado = empleadoService.crearEmpleado(dto);
		return Response.status(Response.Status.CREATED).entity(creado).build();
	}

	@GET
	@Path("/estadisticas/salario-maximo")
	public Double obtenerSalarioMaximo() {
		return empleadoService.obtenerSalarioMaximo();
	}

	@GET
	@Path("/estadisticas/salario-promedio")
	public Double obtenerPromedioSalarios() {
		return empleadoService.obtenerPromedioSalarios();
	}

	@GET
	@Path("/estadisticas/departamento/{nombre}/conteo")
	public long contarPorDepartamento(@PathParam("nombre") String nombre) {
		return empleadoService.contarEmpleadosPorDepartamento(nombre);
	}
}
