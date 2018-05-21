package controlador;

import modelo.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.User;

public class Logear extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		ModelUser mu = new ModelUser();

		User user;

		if (mu.selectUserName(nombre) != null) {
			user = mu.selectUserName(nombre);
		} else {
			user = new User();
		}

		if (nombre.equals(user.getUsername()) && password.equals(user.getPassword())) {

			HttpSession session = request.getSession();

			session.setAttribute("usuario", user);

			RequestDispatcher rd = request.getRequestDispatcher("ListarUsuarios");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adios.html");
			rd.forward(request, response);
		}
	}
}
