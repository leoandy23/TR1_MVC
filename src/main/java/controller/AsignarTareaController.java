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
import model.Responsable;
import model.Tarea;

@WebServlet("/AsignarTareaController")
public class AsignarTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AsignarTareaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Director director = (Director) session.getAttribute("directorLogeado");
		if (director == null) {
			response.sendRedirect("LoginController");
			return;
		}
		
		Integer codigoTarea = Integer.parseInt(request.getParameter("codigoTarea"));
		
		Tarea modeloTarea = new Tarea();
		Tarea tarea = modeloTarea.getPorCodigo(codigoTarea);
		request.setAttribute("tarea", tarea);
		
		Responsable modeloResponsable = new Responsable();
		List<Responsable> listaResponsables = modeloResponsable.getResponsables();
		request.setAttribute("responsables", listaResponsables);
		
		request.setAttribute("director", director);
		
		request.getRequestDispatcher("jsp/asignarTarea.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.- Obtener datos que me envían en la solicitud
		Integer codigoTarea = Integer.parseInt(request.getParameter("id"));
		Integer idResponsable = Integer.parseInt(request.getParameter("responsable-task"));
		
		// 2.- Llamo al Modelo para obtener datos
		Tarea modeloTarea = new Tarea();
		Tarea tarea = modeloTarea.getPorCodigo(codigoTarea);
		
		Responsable modeloResponsable = new Responsable();
		Responsable responsable = modeloResponsable.getById(idResponsable);
		
		tarea.asignar(tarea, responsable);
		
		// 3.- Llamo a la vista
		response.sendRedirect("MenuDirectorController");
	}

}
