package com.miempresa.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {
	// Activa la ruta base /api para todos los servicios REST
}