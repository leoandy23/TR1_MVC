package model;

public class Director extends Persona {
	
	private static final long serialVersionUID = 1L;
	public static Director director = null;

	public Director() {

	}

	public Director(int id, String nombre, String password) {
		super(id, nombre, password);

	}
	
	public Director getDirector() {
		if(director == null) {
			director = new Director (1, "Luis", "luis123");
		}
		return director;
	}

}
