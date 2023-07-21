package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tarea;

@WebServlet("/CompletarTareaController")
public class CompletarTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompletarTareaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer codigoTarea = Integer.parseInt(request.getParameter("codigoTarea"));

		Tarea modeloTarea = new Tarea();
		Tarea tarea = modeloTarea.getPorCodigo(codigoTarea);
		modeloTarea.completarTarea(tarea);
		
		response.sendRedirect("MenuResponsableController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}