package LD;

public class Aeropuerto {
	public int id;
	public String nom_aeropuerto;
	public String abreviatura;
	
	public Aeropuerto(int id, String nom_aeropuerto, String abreviatura) {
		super();
		this.id = id;
		this.nom_aeropuerto = nom_aeropuerto;
		this.abreviatura = abreviatura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
