package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private String password;
	
	private static List<Persona> personas = null;
	
	public Persona () {
		
	}
	
	public Persona(int id, String nombre, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// Reglas del negocio
	
	public Persona autorizar(String usuario, String password) {
		Persona personaAutorizada = null;
		List<Persona> listaPersona = this.getPersonas();
		for (Persona persona : listaPersona) {
			if(persona.getNombre().equals(usuario) && persona.getPassword().equals(password)) {
				personaAutorizada = persona;
				break;
			}
		}
		return personaAutorizada;
	}
	
	
	public List<Persona> getPersonas() {
		if (personas == null) {
			personas = new ArrayList<>();
			Responsable responsable = new Responsable();
			Director director = new Director();
			personas.add(director.getDirector());
			personas.addAll(responsable.getResponsables());
		}
		return personas;
	}
}
