package com.miempresa.empleado;

import java.time.LocalDate;

public class EmpleadoDTO {
	private Long id;
	private String nombre;
	private String departamento;
	private Double salario;
	private LocalDate fechaContratacion;
	private Boolean activo;

	// Constructor vacio
	public EmpleadoDTO() {
	}

	// Constructor con parametros
	public EmpleadoDTO(Long id, String nombre, String departamento, Double salario, LocalDate fechaContratacion,
			Boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
		this.fechaContratacion = fechaContratacion;
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}