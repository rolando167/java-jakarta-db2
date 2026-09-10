package com.miempresa.service;

import java.util.List;

import com.miempresa.dto.ProfesorDTO;

public interface ProfesorService {
	List<ProfesorDTO> obtenerProfesores();

	ProfesorDTO obtenerPorId(Long id); // <--- Nuevo

	ProfesorDTO crearProfesor(ProfesorDTO dto);

	ProfesorDTO actualizarProfesor(Long id, ProfesorDTO dto); // <--- Nuevo

	boolean eliminarProfesor(Long id); // <--- Nuevo
}