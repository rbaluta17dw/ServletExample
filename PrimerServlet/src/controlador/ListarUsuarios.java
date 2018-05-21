package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModelUser;
import modelo.User;

public class ListarUsuarios extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User usuario = (User) session.getAttribute("usuario");

		if (usuario != null) {

			String nombreUsuario = request.getParameter("nombre");

			ModelUser muser = new ModelUser();

			ArrayList<User> usuarios = muser.selectAll();

			User user = new User();

			user.setUsername(nombreUsuario);

			usuarios.add(user);

			request.setAttribute("usuarios", usuarios);

			RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("adios.html");
		}
	}
}
