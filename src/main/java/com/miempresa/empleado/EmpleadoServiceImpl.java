package com.miempresa.empleado;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmpleadoServiceImpl implements EmpleadoService {

	@Inject
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<EmpleadoDTO> obtenerEmpleados() {
		return empleadoRepository.listarTodos().stream().map(e -> new EmpleadoDTO(e.getId(), e.getNombre(),
				e.getDepartamento(), e.getSalario(), e.getFechaContratacion(), e.getActivo()))
				.collect(Collectors.toList());
	}

	@Override
	public EmpleadoDTO obtenerPorId(Long id) {
		Empleado e = empleadoRepository.buscarPorId(id);
		if (e == null)
			return null;
		return new EmpleadoDTO(e.getId(), e.getNombre(), e.getDepartamento(), e.getSalario(), e.getFechaContratacion(),
				e.getActivo());
	}

	@Override
	public EmpleadoDTO crearEmpleado(EmpleadoDTO dto) {
		Empleado e = new Empleado(null, dto.getNombre(), dto.getDepartamento(), dto.getSalario(),
				dto.getFechaContratacion(), dto.getActivo());
		empleadoRepository.guardar(e);
		dto.setId(e.getId());
		return dto;
	}

	@Override
	public Double obtenerSalarioMaximo() {
		return empleadoRepository.listarTodos().stream().mapToDouble(e -> e.getSalario() != null ? e.getSalario() : 0.0)
				.max().orElse(0.0);
	}

	@Override
	public Double obtenerPromedioSalarios() {
		return empleadoRepository.listarTodos().stream().mapToDouble(e -> e.getSalario() != null ? e.getSalario() : 0.0)
				.average().orElse(0.0);
	}

	@Override
	public long contarEmpleadosPorDepartamento(String departamento) {
		return empleadoRepository.listarTodos().stream().filter(e -> departamento.equalsIgnoreCase(e.getDepartamento()))
				.count();
	}
}