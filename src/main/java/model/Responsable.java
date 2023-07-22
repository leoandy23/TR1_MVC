package model;

import java.util.ArrayList;
import java.util.List;

public class Responsable extends Persona {
	
	private static final long serialVersionUID = 1L;
	private String area;
	private static List<Responsable> responsables = null;
	
	public Responsable() {

	}
	
	public Responsable(int id, String nombre, String password, String area) {
		super(id, nombre, password);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	// Reglas del negocio
	
	public List<Responsable> getResponsables() {
		if (responsables == null) {
			responsables = new ArrayList<>();

			responsables.add(new Responsable(2, "Pépe", "pepe123", "Pago de Salarios"));
			responsables.add(new Responsable(3, "María", "maria123", "Becas y estímulos"));
			responsables.add(new Responsable(4, "Mariana", "mariana123", "Salud Laboral"));
		}
		return responsables;
	}
	
	public Responsable getById(int id) {
		Responsable r = null;
		List<Responsable> listaResponsables = this.getResponsables();

		for (Responsable responsable : listaResponsables) {
			if (responsable.getId() == id) {
				r = responsable;
				break;
			}
		}
		return r;
	}
}
