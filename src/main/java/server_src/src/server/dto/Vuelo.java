package src.server.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class Vuelo implements Serializable{
	
	private String cod_vuelo;
	private long price;
	private long num_asientos_tot;
	private long num_asientos_disp;
	private String fecha_salida;
	private LocalDateTime fecha_salida_con_horas;
	private Aeropuerto aeropuerto_origen;
	private Aeropuerto aeropuerto_destino;
	private Aerolinea aerolinea;
	
	
	public Vuelo(String cod_vuelo, long price, long num_asientos_tot, long num_asientos_disp, String fecha_salida, LocalDateTime fecha_salida_con_horas, Aeropuerto aeropuerto_origen, Aeropuerto aeropuerto_destino, Aerolinea aerolinea) {
		super();
		this.cod_vuelo = cod_vuelo;
		this.price = price;
		this.num_asientos_tot = num_asientos_tot;
		this.num_asientos_disp = num_asientos_disp;
		this.fecha_salida = fecha_salida;
		this.fecha_salida_con_horas = fecha_salida_con_horas;
		this.aeropuerto_origen = aeropuerto_origen;
		this.aeropuerto_destino = aeropuerto_destino;
		this.aerolinea = aerolinea;
	}


	public String getCod_vuelo() {
		return cod_vuelo;
	}


	public void setCod_vuelo(String cod_vuelo) {
		this.cod_vuelo = cod_vuelo;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	public long getNum_asientos_tot() {
		return num_asientos_tot;
	}


	public void setNum_asientos_tot(long num_asientos_tot) {
		this.num_asientos_tot = num_asientos_tot;
	}


	public long getNum_asientos_disp() {
		return num_asientos_disp;
	}


	public void setNum_asientos_disp(long num_asientos_disp) {
		this.num_asientos_disp = num_asientos_disp;
	}


	public String getFecha_salida() {
		return fecha_salida;
	}


	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}


	public LocalDateTime getFecha_salida_con_horas() {
		return fecha_salida_con_horas;
	}


	public void setFecha_salida_con_horas(LocalDateTime fecha_salida_con_horas) {
		this.fecha_salida_con_horas = fecha_salida_con_horas;
	}


	public Aeropuerto getAeropuerto_origen() {
		return aeropuerto_origen;
	}


	public void setAeropuerto_origen(Aeropuerto aeropuerto_origen) {
		this.aeropuerto_origen = aeropuerto_origen;
	}


	public Aeropuerto getAeropuerto_destino() {
		return aeropuerto_destino;
	}


	public void setAeropuerto_destino(Aeropuerto aeropuerto_destino) {
		this.aeropuerto_destino = aeropuerto_destino;
	}


	public Aerolinea getAerolinea() {
		return aerolinea;
	}


	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}



	

}
