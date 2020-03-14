package LD;

public class Reserva {
	
	public int id_reserva;
	public float precio;
	
	public Reserva(int id_reserva, float precio) {
		super();
		this.id_reserva = id_reserva;
		this.precio = precio;
	}
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
