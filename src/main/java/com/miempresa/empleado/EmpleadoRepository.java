package com.miempresa.empleado;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class EmpleadoRepository {

	@PersistenceContext
	private EntityManager em;

	public List<Empleado> listarTodos() {
		return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
	}

	public Empleado buscarPorId(Long id) {
		return em.find(Empleado.class, id);
	}

	public void guardar(Empleado empleado) {
		em.persist(empleado);
	}
}