package src.server.dto;

import java.io.Serializable;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Persona implements Serializable {
	
	@PrimaryKey
	public int dni_persona;
	public String nombre;
	public String apellido;
	@Persistent(mappedBy="personasRes")
	Set<Reserva> reservas;
	
	public Persona(int dni_persona, String nombre, String apellido) {
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
