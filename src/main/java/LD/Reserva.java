package LD;

import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long id_reserva;
	private float precio;
	private int idAerolinea;
	@Persistent(table="RESERVAS_PERSONAS")
	@Join(column="id_reserva")
	@Element(column="dni")
	Set<Persona> personasRes;
	
	
	//Constructor
	public Reserva(float precio) {
		this.precio = precio;
	}
	public long getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
