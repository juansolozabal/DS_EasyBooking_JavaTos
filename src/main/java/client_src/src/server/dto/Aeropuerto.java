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
	
	@Override
	public String toString() {
		return nom_aeropuerto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abreviatura == null) ? 0 : abreviatura.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom_aeropuerto == null) ? 0 : nom_aeropuerto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeropuerto other = (Aeropuerto) obj;
		if (abreviatura == null) {
			if (other.abreviatura != null)
				return false;
		} else if (!abreviatura.equals(other.abreviatura))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom_aeropuerto == null) {
			if (other.nom_aeropuerto != null)
				return false;
		} else if (!nom_aeropuerto.equals(other.nom_aeropuerto))
			return false;
		return true;
	}	
}
