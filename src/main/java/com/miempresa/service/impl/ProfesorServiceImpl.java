package com.miempresa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.miempresa.dto.ProfesorDTO;
import com.miempresa.entity.Profesor;
import com.miempresa.repository.ProfesorRepository;
import com.miempresa.service.ProfesorService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProfesorServiceImpl implements ProfesorService {

	private final ProfesorRepository profesorRepository;

	// CDI requiere un constructor por defecto sin argumentos
	public ProfesorServiceImpl() {
		this.profesorRepository = null;
	}

	@Inject
	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		this.profesorRepository = profesorRepository;
	}

	@Override
	public List<ProfesorDTO> obtenerProfesores() {
		return profesorRepository.listarTodos().stream().map(this::convertirADTO).collect(Collectors.toList());
	}

	@Override
	public ProfesorDTO crearProfesor(ProfesorDTO dto) {
		Profesor profesor = new Profesor(dto.getNombre(), dto.getApellido(), dto.getEmail());
		Profesor guardado = profesorRepository.guardar(profesor);
		return convertirADTO(guardado);
	}

	// Mapper simple para convertir Entidad a DTO
	private ProfesorDTO convertirADTO(Profesor profesor) {
		return new ProfesorDTO(profesor.getId(), profesor.getNombre(), profesor.getApellido(), profesor.getEmail());
	}

	@Override
	public ProfesorDTO obtenerPorId(Long id) {
		Profesor profesor = profesorRepository.buscarPorId(id); // Asegúrate de tener este método en tu repositorio
		if (profesor != null) {
			return convertirADTO(profesor);
		}
		return null; // El Resource manejará el 404
	}

	@Override
	@Transactional // Importante para operaciones de escritura/actualización
	public ProfesorDTO actualizarProfesor(Long id, ProfesorDTO dto) {
		Profesor profesorExistente = profesorRepository.buscarPorId(id);
		if (profesorExistente != null) {
			// Actualizamos los campos de la entidad con los datos del DTO
			profesorExistente.setNombre(dto.getNombre());
			profesorExistente.setApellido(dto.getApellido());
			profesorExistente.setEmail(dto.getEmail());

			Profesor actualizado = profesorRepository.actualizar(profesorExistente); // O guardar, dependiendo de tu
																						// repo
			return convertirADTO(actualizado);
		}
		return null;
	}

	@Override
	@Transactional
	public boolean eliminarProfesor(Long id) {
		Profesor profesor = profesorRepository.buscarPorId(id);
		if (profesor != null) {
			profesorRepository.eliminar(profesor); // Asegúrate de tener este método en tu repositorio
			return true;
		}
		return false;
	}
}