package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PruebaForm
 */
@WebServlet("/PruebaForm")
public class PruebaForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PruebaForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println(request.getParameter("provincia"));
		String deacuerdo = request.getParameter("deacuerdo");

		if (deacuerdo == null) {
			out.println("No estoy de acuerdo con que se lleven mi alma");
		} else {
			out.println("Estoy de acuerdo con que se lleven mi alma");
		}
		String[] ingredientes = request.getParameterValues("ingredientes");

		for (int i = 0; i < ingredientes.length; i++) {
			out.println(ingredientes[i]);
		}
		out.println(request.getParameter("busqueda"));
		out.println(request.getParameter("fecha"));
		out.println(request.getParameter("color"));
		out.println(request.getParameter("rango"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
