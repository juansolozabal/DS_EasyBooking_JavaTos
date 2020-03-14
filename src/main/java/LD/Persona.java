package LD;

public class Persona {
	
	public int dni_persona;
	public String nombre;
	public String apellido;
	
	public Persona(int dni_persona, String nombre, String apellido) {
		super();
		this.dni_persona = dni_persona;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getDni_persona() {
		return dni_persona;
	}

	public void setDni_persona(int dni_persona) {
		this.dni_persona = dni_persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}
