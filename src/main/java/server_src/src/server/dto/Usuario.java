package src.server.dto;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Usuario {
	@PrimaryKey
	private String correo;
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long id_usuario;
	private String nombre;
	private String apellido;
	

	@Element(column="id_usuario")
	private ArrayList<Reserva> reservasUsu = new ArrayList<Reserva>();	
	
	
	public Usuario(String nombre, String apellido, String correo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;

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
