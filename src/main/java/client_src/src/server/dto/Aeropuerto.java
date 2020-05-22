package src.server.dto;

import java.io.Serializable;

public class Aeropuerto implements Serializable{
	public String id;
	public String nom_aeropuerto;
	public String abreviatura;
	
	public Aeropuerto(String id, String nom_aeropuerto) {
		super();
		this.id = id;
		this.nom_aeropuerto = nom_aeropuerto;
		this.abreviatura = nom_aeropuerto.substring(0, 3).toUpperCase();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom_aeropuerto() {
		return nom_aeropuerto;
	}

	public void setNom_aeropuerto(String nom_aeropuerto) {
		this.nom_aeropuerto = nom_aeropuerto;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
		

}
