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
	
	public String pagarPayPal (String email, float amount, String concept)
	{
		String respuesta = new String();
		try {
			respuesta = this.pagosGway.makePayment(email, amount, concept); 
			return respuesta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.toString();
			return respuesta;
		}
	}
	
	public String pagarVisa (String email, float amount, String concept)
	{
		String respuesta = new String();
		try {
			respuesta = this.pagosGway.makePayment(email, amount, concept); 
			return respuesta;
		} catch (Exception e) {
			e.toString();
			return respuesta;
		}
	}
	
	public boolean crearUsuario (String nombre, String apellido, String email, float amount) {
		boolean registro;
		try {
			registro = this.pagosGway.createUser(nombre, apellido, email, amount);
			if(registro == true) {
				System.out.println("¡Registro en el microservicio de Pagos realizado con exito!");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
