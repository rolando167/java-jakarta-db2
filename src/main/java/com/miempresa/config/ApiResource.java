package com.miempresa.config;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class ApiResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String inicioApi() {
		return "Bienvenido a la API de Jakarta EE 10 en WildFly. Todo esta funcionando correctamente.";
	}
}