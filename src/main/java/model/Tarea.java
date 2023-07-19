package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int contador = 0;
	private int codigo;
	private String nombre;
	private String estado;
	private Responsable responsable;

	private static List<Tarea> tareas = null;

	public Tarea() {

	}

	public Tarea(String nombre) {
		super();
		this.codigo = ++contador;
		this.nombre = nombre;
		this.estado = "Por Asignar";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	// Reglas del negocio

	public List<Tarea> getTareas() {
		if (tareas == null) {
			tareas = new ArrayList<>();
		}
		return tareas;
	}

	public Tarea getPorCodigo(int codigo) {
		Tarea t = null;
		List<Tarea> listaTareas = this.getTareas();

		for (Tarea tarea : listaTareas) {
			if (tarea.getCodigo() == codigo) {
				t = tarea;
				break;
			}
		}
		return t;
	}

	public void create(Tarea t) {
		this.getTareas().add(t);
	}


	public void asignar(int codigo, Responsable responsable) {
		List<Tarea> listaTareas = this.getTareas();

		for (Tarea tarea : listaTareas) {
			if (tarea.getCodigo() == codigo) {
				tarea.setResponsable(responsable);
				tarea.setEstado("Por Hacer");
				break;
			}
		}
	}

	public List<Tarea> getPorResponsable(int id) {
		List<Tarea> listaTareas = this.getTareas();
		List<Tarea> listaTareasPorResponsable = new ArrayList<>();

		for (Tarea tarea : listaTareas) {
			if (tarea.getResponsable() != null && tarea.getResponsable().getId() == id) {
				listaTareasPorResponsable.add(tarea);
			}
		}
		return listaTareasPorResponsable;
	}

	public void completarTarea() {
		List<Tarea> listaTareas = this.getTareas();

		for (Tarea tarea : listaTareas) {
			if (tarea.getCodigo() == codigo) {
				tarea.setEstado("Completado");
				break;
			}
		}
	}
	
	public List<Tarea> getPorNombre (String nombre){
		List<Tarea> listaTareas = this.getTareas();
		List<Tarea> listaTareasPorNombre = new ArrayList<>();

		for (Tarea tarea : listaTareas) {
			if (tarea.getNombre() == nombre) {
				listaTareasPorNombre.add(tarea);
			}
		}
		return listaTareasPorNombre;
	}
	
	public List<Tarea> getPorNombreYResponsable (int id, String nombre){
		List<Tarea> listaTareas = this.getTareas();
		List<Tarea> listaTareasPorNombre = new ArrayList<>();

		for (Tarea tarea : listaTareas) {
			if (tarea.getResponsable() != null && tarea.getResponsable().getId() == id && tarea.getNombre() == nombre ) {
				listaTareasPorNombre.add(tarea);
			}
		}
		return listaTareasPorNombre;
	}

}
