package src.server.dto;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Usuario {
	@PrimaryKey
	private int dni;
	private String nombre;
	private String apellido;
	private String correo;
	private int pin;
	private int idAeropuerto;
	
	@Element(column="dni")
	private ArrayList<Reserva> reservasUsu = new ArrayList<Reserva>();	
	
	
	public Usuario(int dni, String nombre, String apellido, String correo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;

	}


	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public ArrayList<Reserva> getReservas(){
		return reservasUsu;
	}
	
}
