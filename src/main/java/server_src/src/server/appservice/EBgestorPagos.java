package src.server.appservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.server.dto.Persona;
import src.server.gateway.PagosToSystem;

public class EBgestorPagos {

	private PagosToSystem pagosGway;
	private static EBgestorPagos gestorPagos = null;

	private EBgestorPagos(){}

//	private EBgestorPagos(String[] args) {
//		this.pagosGway = new PagosToSystem(args[0], args[1]);
//	}

	public static EBgestorPagos getGestorPagos()
	{
		synchronized(EBgestorPagos.class)
		{
			if (gestorPagos == null) gestorPagos = new EBgestorPagos();
		}
		return gestorPagos;
	}
	
	public void setArgs(String[] args)
	{
		pagosGway = new PagosToSystem(args[0], args[1]);
	}
	
	public void hacerReserva (int codVuelo, String nomUsuario, ArrayList<Persona> pasajeros)
	{
		this.pagosGway.hacerReserva(codVuelo, nomUsuario, pasajeros);
	}
	
	public void pagarPayPal (String email, String contrasenya)
	{
		this.pagosGway.pagarPayPal(email, contrasenya);
	}
	
	public void pagarVisa (String nomTitular, int numTarj, Date venc, int cvc)
	{
		this.pagosGway.pagarVisa(nomTitular, numTarj, venc, cvc);
	}

}
