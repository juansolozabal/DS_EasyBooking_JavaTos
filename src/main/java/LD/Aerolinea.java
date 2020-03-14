package LD;

public class Aerolinea {
	
	public int id;
	public String nom_aerolinea;
	
	public Aerolinea(int id, String nom_aerolinea) {
		super();
		this.id = id;
		this.nom_aerolinea = nom_aerolinea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_aerolinea() {
		return nom_aerolinea;
	}

	public void setNom_aerolinea(String nom_aerolinea) {
		this.nom_aerolinea = nom_aerolinea;
	}
	
	

}
