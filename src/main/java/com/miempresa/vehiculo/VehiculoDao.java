package com.miempresa.vehiculo;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class VehiculoDao {

	@PersistenceContext
	private EntityManager em;

	public List<Vehiculo> listarVehiculos() {
		return em.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class).getResultList();
	}

	public void guardar(Vehiculo vehiculo) {
		em.persist(vehiculo); // El EJB maneja la transacción automáticamente
	}
}