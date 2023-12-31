package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Director;
import model.Persona;
import model.Responsable;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("username");
		String clave = request.getParameter("pswd");

		Persona modeloPersona = new Persona();
		Persona personaAutenticada = modeloPersona.autorizar(nombre, clave);

		if (personaAutenticada != null) {
			// Crear la sesion
			HttpSession session = request.getSession();
			
			if (personaAutenticada instanceof Director) {
                session.setAttribute("directorLogeado", (Director) personaAutenticada);
                response.sendRedirect("MenuDirectorController");
			}
			
			if (personaAutenticada instanceof Responsable) {
                session.setAttribute("responsableLogeado", (Responsable) personaAutenticada);
                response.sendRedirect("MenuResponsableController");
			}
			return;
		} else {
			String mensaje = "Ingresaste mal tu usuario o clave";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}

	}

}
