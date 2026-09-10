package com.miempresa.config;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hola")
public class HolaResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String saludar() {
		return "¡Hola Mundo desde Jakarta EE 10 y WildFly 41!";
	}
}