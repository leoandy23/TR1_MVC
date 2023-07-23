package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Director;
import model.Responsable;
import model.Tarea;

@WebServlet("/CrearTareaController")
public class CrearTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrearTareaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Responsable responsable = (Responsable) session.getAttribute("responsableLogeado");
		Director director = (Director) session.getAttribute("directorLogeado");
		if (director == null) {
			response.sendRedirect("LoginController");
			return;
		}else if (responsable != null) {
			response.sendRedirect("LoginController");
			return;
		}
		
		
		request.getRequestDispatcher("jsp/crearTarea.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.- Obtener datos que me env�an en la solicitud
		HttpSession session = request.getSession();
		Director director = (Director) session.getAttribute("directorLogeado");
		
		
		request.setAttribute("nombreDirector", director.getNombre());
		String nombreTarea = request.getParameter("taskname");

		// 2.- Llamo al Modelo para obtener datos
		Tarea tarea = new Tarea();
		tarea.setEstado("Por Asignar");
		tarea.setNombre(nombreTarea);
		
		
		Tarea modeloTarea = new Tarea();
		modeloTarea.create(tarea);
		
		
		// 3.- Llamo a la vista
		request.getRequestDispatcher("jsp/crearTarea.jsp").forward(request, response);
		
	}

}
