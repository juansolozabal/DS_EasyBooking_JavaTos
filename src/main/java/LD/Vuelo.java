package LD;

import java.sql.Time;

public class Vuelo {
	
	public int cod_vuelo;
	public int num_asientos_tot;
	public int num_asientos_disp;
	public Time hora_salida;
	public Time hora_llegada;
	
	public Vuelo(int cod_vuelo, int num_asientos_tot, int num_asientos_disp, Time hora_salida, Time hora_llegada) {
		super();
		this.cod_vuelo = cod_vuelo;
		this.num_asientos_tot = num_asientos_tot;
		this.num_asientos_disp = num_asientos_disp;
		this.hora_salida = hora_salida;
		this.hora_llegada = hora_llegada;
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

	public Time getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(Time hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Time getHora_llegada() {
		return hora_llegada;
	}

	public void setHora_llegada(Time hora_llegada) {
		this.hora_llegada = hora_llegada;
	}
	
	
	

}
