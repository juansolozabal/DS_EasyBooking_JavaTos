package src.server.gateway;

import java.util.ArrayList;
import java.util.Date;

import src.server.dto.Aeropuerto;
import src.server.dto.Vuelo;

public interface IGatewayAero {
	public void makeGetRequest();
	public void makePutRequest();
	public void makePostRequest();
	public ArrayList<Vuelo> getVuelos();
	public ArrayList<Vuelo> buscarVuelos(Date fecha, String nomOrigen, String nomDestino);
}
