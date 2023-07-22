package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tarea;
import model.Responsable;

@WebServlet("/MenuResponsableController")
public class MenuResponsableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuResponsableController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Responsable responsable = (Responsable) session.getAttribute("usuarioLogeado");
		
		Tarea modeloTarea = new Tarea();
		List<Tarea> listaTareas = modeloTarea.getPorResponsable(responsable);
		
		request.setAttribute("tareas", listaTareas);
		request.setAttribute("nombreResponsable", responsable.getNombre());
		request.getRequestDispatcher("jsp/menuResponsable.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
