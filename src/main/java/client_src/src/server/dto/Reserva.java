package src.server.dto;

import java.util.ArrayList;
import java.util.HashSet;
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
	private float precioTotal;
	private int cod_vuelo;
	@Persistent(table="RESERVAS_PERSONAS")
	@Join(column="id_reserva")
	@Element(column="dni")
	Set<Persona> personasRes;
	
	
	//Constructor
	public Reserva(int cod_vuelo) {
		this.cod_vuelo = cod_vuelo;
		personasRes = new HashSet<Persona>();
	}
	public long getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecio(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	public int getCod_vuelo() {
		return cod_vuelo;
	}
	public void setCod_vuelo(int cod_vuelo) {
		this.cod_vuelo = cod_vuelo;
	}
	public Set<Persona> getPersonasRes() {
		return personasRes;
	}
	public void setPersonasRes(Set<Persona> personasRes) {
		this.personasRes = personasRes;
	}
	
	

}
