package com.miempresa.empleado;

import java.util.List;

public interface EmpleadoService {
	List<EmpleadoDTO> obtenerEmpleados();

	EmpleadoDTO obtenerPorId(Long id);

	EmpleadoDTO crearEmpleado(EmpleadoDTO dto);

	Double obtenerSalarioMaximo();

	Double obtenerPromedioSalarios();

	long contarEmpleadosPorDepartamento(String departamento);
}