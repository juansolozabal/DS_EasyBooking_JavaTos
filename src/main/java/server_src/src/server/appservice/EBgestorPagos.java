package src.server.appservice;

import java.util.Date;
import java.util.List;

import src.server.dto.Persona;
import src.server.gateway.AeroToSystem;
import src.server.gateway.PagosToSystem;

public class EBgestorPagos {

	private PagosToSystem pagosGway;

	public EBgestorPagos(String[] args) {
		this.pagosGway = new PagosToSystem(args[0], args[1]);
	}

	public void hacerReserva (String nomUsu, int cod_vuelo, float precio, List<Persona>pasajeros)
	{
		this.pagosGway.hacerReserva(nomUsu, cod_vuelo, precio, pasajeros);
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
