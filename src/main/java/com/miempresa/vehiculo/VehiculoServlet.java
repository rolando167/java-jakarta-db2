package com.miempresa.vehiculo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/legacy/vehiculos")
public class VehiculoServlet extends HttpServlet {

	@Inject
	private VehiculoDao vehiculoDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("");

		for (Vehiculo v : vehiculoDao.listarVehiculos()) {
			out.println(" " + v.getMarca() + " - " + v.getModelo() + " ($" + v.getPrecio() + ")");
			out.println("");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Captura manual de parametros del formulario HTML o request tradicional
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		Double precio = Double.parseDouble(request.getParameter("precio"));

		Vehiculo v = new Vehiculo(marca, modelo, precio);
		vehiculoDao.guardar(v);

		response.getWriter().write("Vehiculo registrado exitosamente mediante Servlet y EJB Stateless.");
	}
}
