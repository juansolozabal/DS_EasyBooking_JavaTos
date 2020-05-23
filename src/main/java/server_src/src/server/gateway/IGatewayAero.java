package src.server.gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.server.dto.Aeropuerto;
import src.server.dto.Vuelo;

public interface IGatewayAero {
	public List<Flight_JSON> getVuelos(Object[] args) throws Exception;
	public List<Flight_JSON> getVuelos() throws Exception;
}

