package com.miempresa.repository;

import java.util.List;

import com.miempresa.entity.Profesor;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProfesorRepository {

	@PersistenceContext(unitName = "MiProyectoPU")
	private EntityManager em;

	public List<Profesor> listarTodos() {
		return em.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();
	}

	public Profesor buscarPorId(Long id) {
		return em.find(Profesor.class, id);
	}

	@Transactional
	public Profesor guardar(Profesor profesor) {
		em.persist(profesor);
		return profesor;
	}

	@Transactional
	public Profesor actualizar(Profesor profesor) {
		return em.merge(profesor);
	}

	@Transactional
	public void eliminar(Profesor profesor) {
		// Aseguramos que la entidad esté gestionada antes de eliminarla
		Profesor managedProfesor = em.contains(profesor) ? profesor : em.merge(profesor);
		em.remove(managedProfesor);
	}
}