package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int contador = 3;
	private int codigo;
	private String nombre;
	private String estado;
	private Responsable responsable;

	private static List<Tarea> tareas = null;

	public Tarea() {
	}

	public Tarea(int codigo, String nombre, String estado, Responsable responsable) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.estado = estado;
		this.responsable = responsable;
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
			Responsable modeloResponsable = new Responsable();
			List<Responsable> listaResponsables = modeloResponsable.getResponsables();
			
			tareas.add(new Tarea(1, "Realizar planillas", "Por Hacer", listaResponsables.get(0)));
			tareas.add(new Tarea(2, "Revisión de becas", "Por Hacer", listaResponsables.get(1)));
			tareas.add(new Tarea(3, "Historiales medicos", "Por Hacer", listaResponsables.get(2)));
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
		t.setCodigo(++contador);
		this.getTareas().add(t);
	}

	public void asignar(Tarea t, Responsable responsable) {
		List<Tarea> listaTareas = this.getTareas();

		for (Tarea tarea : listaTareas) {
			if (tarea.getCodigo() == t.getCodigo()) {
				tarea.setResponsable(responsable);
				tarea.setEstado("Por Hacer");
				break;
			}
		}
	}


	public void completarTarea(Tarea t) {
		List<Tarea> listaTareas = this.getTareas();

		for (Tarea tarea : listaTareas) {
			if (tarea.getCodigo() == t.getCodigo()) {
				tarea.setEstado("Completado");
				break;
			}
		}
	}
	
	public List<Tarea> getPorResponsable(Responsable responsable){
		List<Tarea> listaTareas = this.getTareas();
		List<Tarea> listaTareasPorNombre = new ArrayList<>();

		for (Tarea tarea : listaTareas) {
			if (tarea.getResponsable() == responsable) {
				listaTareasPorNombre.add(tarea);
			}
		}
		return listaTareasPorNombre;
	}
	
}
