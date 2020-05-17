package src.server.gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.server.dto.Persona;

public interface IGatewayPagos {
	public void makeGetRequest();
	public void makePutRequest();
	public void makePostRequest();
	public void hacerReserva (int codVuelo, String nomUsuario, ArrayList<Persona> pasajeros);
	public void pagarPayPal (String email, String contrasenya);
	public void pagarVisa (String nomTitular, int numTarj, Date venc, int cvc);
}
