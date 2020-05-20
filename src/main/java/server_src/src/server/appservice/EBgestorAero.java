package src.server.appservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.server.dto.Aeropuerto;
import src.server.dto.Vuelo;
import src.server.gateway.AeroToSystem;
import src.server.gateway.AuthToSystem;
import src.server.gateway.Flight_JSON;
import src.server.gateway.IGatewayAero;

public class EBgestorAero {

	private IGatewayAero aeroGway;
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
	
	public List<Flight_JSON> getVuelos()
	{
		try {
			return this.aeroGway.getVuelos(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	public List<Flight_JSON> getVuelos(String nomOrigen, String nomDestino)
	{
		String [] parameters_Array = new String [2];
		parameters_Array[0] = nomOrigen;
		parameters_Array[1] = nomDestino;
		
		try {
			return this.aeroGway.getVuelos(parameters_Array);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
