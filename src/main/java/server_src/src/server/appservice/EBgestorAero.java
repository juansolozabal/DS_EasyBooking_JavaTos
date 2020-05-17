package src.server.appservice;

import java.util.ArrayList;
import java.util.Date;

import src.server.dto.Aeropuerto;
import src.server.dto.Vuelo;
import src.server.gateway.AeroToSystem;
import src.server.gateway.AuthToSystem;

public class EBgestorAero {

	private AeroToSystem aeroGway;
	private static EBgestorAero gestorAero = null;
	
	private EBgestorAero(){}
	
//	private EBgestorAero(String[] args) {
//		this.aeroGway = new AeroToSystem(args[0], args[1]);
//	}

	public static EBgestorAero getGestorAero()
	{
		synchronized(EBgestorAero.class)
		{
			if (gestorAero == null) gestorAero = new EBgestorAero();
		}
		return gestorAero;
	}
	
	public void setArgs(String[] args)
	{
		aeroGway = new AeroToSystem(args);
	}
	
	public ArrayList<Vuelo> getVuelos()
	{
		return this.aeroGway.getVuelos();	
	}
	
	public ArrayList<Vuelo> buscarVuelos(Date fecha, String nomOrigen, String nomDestino)
	{
		return this.aeroGway.buscarVuelos(fecha, nomOrigen, nomDestino);
	}
	
}
