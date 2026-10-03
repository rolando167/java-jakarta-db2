<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado de Vehículos (JSP)</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 40px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 12px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

.sin-datos {
	color: #666;
	font-style: italic;
}
</style>
</head>
<body>

	<h2>Listado de Vehículos disponibles</h2>

	<!-- Comprobamos si la lista no está vacía -->
	<c:choose>
		<c:when test="${not empty listaVehiculos}">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Marca</th>
						<th>Modelo</th>
						<th>Año</th>
					</tr>
				</thead>
				<tbody>
					<!-- El varStatus nos ayuda si necesitamos un contador o índice -->
					<c:forEach var="vehiculo" items="${listaVehiculos}">
						<tr>
							<!-- Asumimos que tu clase Vehiculo tiene los métodos getId(), getMarca(), etc. -->
							<td><c:out value="${vehiculo.id}" /></td>
							<td><c:out value="${vehiculo.marca}" /></td>
							<td><c:out value="${vehiculo.modelo}" /></td>
							<td><c:out value="${vehiculo.anio}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<p class="sin-datos">No hay vehículos registrados en el sistema
				actualmente.</p>
		</c:otherwise>
	</c:choose>

</body>
</html>