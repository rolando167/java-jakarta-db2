package com.miempresa.resource;

import java.util.List;

import com.miempresa.dto.ProfesorDTO;
import com.miempresa.service.ProfesorService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/profesores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfesorResource {

	private final ProfesorService profesorService;

	// 1. Constructor vacío requerido por CDI
	public ProfesorResource() {
		this.profesorService = null;
	}

	// 2. Inyección por constructor
	@Inject
	public ProfesorResource(ProfesorService profesorService) {
		this.profesorService = profesorService;
	}

	@GET
	public Response listar() {
		List<ProfesorDTO> lista = profesorService.obtenerProfesores();
		return Response.ok(lista).build();
	}

	@POST
	public Response crear(ProfesorDTO dto) {
		ProfesorDTO nuevo = profesorService.crearProfesor(dto);
		return Response.status(Response.Status.CREATED).entity(nuevo).build();
	}

	@GET
	@Path("/{id}")
	public Response buscarPorId(@PathParam("id") Long id) {
		ProfesorDTO profesor = profesorService.obtenerPorId(id);
		if (profesor != null) {
			return Response.ok(profesor).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@PUT
	@Path("/{id}")
	public Response actualizar(@PathParam("id") Long id, ProfesorDTO dto) {
		ProfesorDTO actualizado = profesorService.actualizarProfesor(id, dto);
		if (actualizado != null) {
			return Response.ok(actualizado).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@DELETE
	@Path("/{id}")
	public Response eliminar(@PathParam("id") Long id) {
		boolean eliminado = profesorService.eliminarProfesor(id);
		if (eliminado) {
			return Response.noContent().build(); // Código 204: Éxito sin contenido de vuelta
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
}