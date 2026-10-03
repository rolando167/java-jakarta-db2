package com.miempresa.vehiculo;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/legacy/vehiculos-jsp")
public class VehiculosJspServlet extends HttpServlet {

	@EJB // O @Inject dependiendo de tu configuración
	private VehiculoDao vehiculoDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Obtenemos la lista del DAO
		List<Vehiculo> vehiculos = vehiculoDao.listarVehiculos();

		// 2. Guardamos la lista en los atributos de la petición (request)
		request.setAttribute("listaVehiculos", vehiculos);

		// 3. Redirigimos (Forward) la petición al archivo JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vehiculos.jsp");

		dispatcher.forward(request, response);
	}
}
