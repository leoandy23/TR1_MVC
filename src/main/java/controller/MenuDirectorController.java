package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Director;
import model.Tarea;

@WebServlet("/MenuDirectorController")
public class MenuDirectorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MenuDirectorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Director director = (Director) session.getAttribute("directorLogeado");
		if (director == null) {
			response.sendRedirect("LoginController");
			return;
		}
		
		Tarea modeloTarea = new Tarea();
		List<Tarea> listaTareas = modeloTarea.getTareas();
		
		request.setAttribute("tareas", listaTareas);
		request.setAttribute("director", director);
		request.getRequestDispatcher("jsp/menuDirector.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
