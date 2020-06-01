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
		pagosGway = new PagosToSystem(args);
	}
	
//	public void hacerReserva (String codVuelo, String nomUsuario, ArrayList<Persona> pasajeros)
//	{
//		
//	}
	
	public void pagarPayPal (String email, String contrasenya)
	{
		try {
			this.pagosGway.makePayment(email, (float) 2.0 ,contrasenya); //TODO para cambiar
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pagarVisa (String nomTitular, int numTarj, Date venc, int cvc)
	{
		try {
			this.pagosGway.makePayment(nomTitular, (float) 2.0 , nomTitular); //TODO para cambiar
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
