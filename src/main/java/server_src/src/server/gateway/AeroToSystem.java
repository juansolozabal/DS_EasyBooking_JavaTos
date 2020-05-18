package src.server.gateway;

import java.util.ArrayList;
import java.util.Date;

import src.server.dto.Aeropuerto;
import src.server.dto.Vuelo;

public class AeroToSystem implements IGatewayAero{

	private String IP;
	private String PORT;
	
	public AeroToSystem(String[] args) {
		super();
		//client = new RestClient<>(args[3], args[6]);
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
	public ArrayList<Vuelo> getVuelos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Vuelo> buscarVuelos(Date fecha, String nomOrigen, String nomDestino) {
		// TODO Auto-generated method stub
		return null;
	}

}