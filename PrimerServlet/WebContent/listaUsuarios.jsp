<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="modelo.User"%>
<%
	ArrayList<User> usuarios = (ArrayList<User>) request.getAttribute("usuarios");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		for (User usuario : usuarios) {
			out.println(usuario.getUsername() + "<br>");
		}
	%>
	<form action="ListarUsuarios">
		<input type="text" name="nombre" /> <input type="submit"
			value="enviar" />
	</form>


	<c:forEach items="${usuarios}" var="user">
		${user.username} <br>
	</c:forEach>
	<c:forEach items="${usuarios}" var="user">
		${user.email} <br>
	</c:forEach>

	<a href="Salir">salir</a>
</body>
</html>