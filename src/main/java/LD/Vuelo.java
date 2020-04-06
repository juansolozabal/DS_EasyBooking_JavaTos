package LD;

import java.sql.Date;
import java.sql.Time;

public class Vuelo {
	
	private int cod_vuelo;
	private int num_asientos_tot;
	private int num_asientos_disp;
	private Date fecha_salida;
	private Date fecha_llegada;
	private Aeropuerto aeropuerto_origen;
	private Aeropuerto aeropuerto_destino;
	private Aerolinea aerolinea;
	
	
	public Vuelo(int cod_vuelo, int num_asientos_tot, int num_asientos_disp, Date fecha_salida, Date fecha_llegada, Aeropuerto aeropuerto_origen, Aeropuerto aeropuerto_destino, Aerolinea aerolinea) {
		super();
		this.cod_vuelo = cod_vuelo;
		this.num_asientos_tot = num_asientos_tot;
		this.num_asientos_disp = num_asientos_disp;
		this.fecha_salida = fecha_salida;
		this.fecha_llegada = fecha_llegada;
		this.aeropuerto_origen = aeropuerto_origen;
		this.aeropuerto_destino = aeropuerto_destino;
		this.aerolinea = aerolinea;
	}

	public int getCod_vuelo() {
		return cod_vuelo;
	}

	public void setCod_vuelo(int cod_vuelo) {
		this.cod_vuelo = cod_vuelo;
	}

	public int getNum_asientos_tot() {
		return num_asientos_tot;
	}

	public void setNum_asientos_tot(int num_asientos_tot) {
		this.num_asientos_tot = num_asientos_tot;
	}

	public int getNum_asientos_disp() {
		return num_asientos_disp;
	}

	public void setNum_asientos_disp(int num_asientos_disp) {
		this.num_asientos_disp = num_asientos_disp;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public Date getFecha_llegada() {
		return fecha_llegada;
	}

	public void setHora_llegada(Date fecha_llegada) {
		this.fecha_llegada = fecha_llegada;
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

	public void setFecha_llegada(Date fecha_llegada) {
		this.fecha_llegada = fecha_llegada;
	}
	
	
	

}
