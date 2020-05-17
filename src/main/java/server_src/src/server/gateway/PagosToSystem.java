package src.server.gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.server.dto.Persona;

public class PagosToSystem implements IGatewayPagos{

	private String IP;
	private String PORT;
	
	public PagosToSystem(String IP, String PORT) {
		super();
		this.IP=IP;
		this.PORT=PORT;
	}

	
// TODO Te dejo esto para ti Juanso, disfrutalo.
	@Override
	public void makeGetRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makePutRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makePostRequest() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void hacerReserva(int codVuelo, String nomUsuario, ArrayList<Persona> pasajeros) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pagarPayPal(String email, String contrasenya) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pagarVisa(String nomTitular, int numTarj, Date venc, int cvc) {
		// TODO Auto-generated method stub
		
	}

}