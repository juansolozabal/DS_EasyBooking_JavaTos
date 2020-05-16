package src.server.appservice;

import java.util.ArrayList;
import java.util.Date;

import src.server.dto.Aeropuerto;
import src.server.dto.Vuelo;
import src.server.gateway.AeroToSystem;
import src.server.gateway.AuthToSystem;

public class EBgestorAero {

	private AeroToSystem aeroGway;

	public EBgestorAero(String[] args) {
		this.aeroGway = new AeroToSystem(args[0], args[1]);
	}

	public ArrayList<Vuelo> getVuelos()
	{
		return this.aeroGway.getVuelos();	
	}
	
	public ArrayList<Vuelo> buscarVuelos(Date fecha, Aeropuerto aeropuerto_origen, Aeropuerto aeropuerto_destino)
	{
		return this.aeroGway.buscarVuelos(fecha, aeropuerto_origen, aeropuerto_destino);
	}
	
}
