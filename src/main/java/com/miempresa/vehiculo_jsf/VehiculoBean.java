package com.miempresa.vehiculo_jsf;

import java.util.List;

import com.miempresa.vehiculo.Vehiculo;
import com.miempresa.vehiculo.VehiculoDao;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("vehiculoBean") // Nombre con el que se llamará desde la vista
@RequestScoped
public class VehiculoBean {

	@Inject
	private VehiculoDao vehiculoDao; // Tu EJB o DAO de siempre

	private List<Vehiculo> listaVehiculos;

	@PostConstruct
	public void init() {
		// Se ejecuta automáticamente al cargar la página
		this.listaVehiculos = vehiculoDao.listarVehiculos();
	}

	// Getter necesario para que la vista lea la lista
	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}
}