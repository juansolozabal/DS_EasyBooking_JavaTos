package src.server.gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import es.deusto.PruebasMicroServicios2.P_User;
import es.deusto.PruebasMicroServicios2.RestClient;
import src.server.dto.Persona;

public class PagosToSystem implements IGatewayPagos{


	private RestClient<P_User> client;
	private String path;
	
	public PagosToSystem() {
		client = new RestClient<>("192.168.6.31", "5001");
	}
	
	@Override
	public String makePayment(String email, float amount, String concept) throws Exception {
		path = "/Paymens/Make_payment";
		boolean operation_result = false;
		String new_payment_response;

		new_payment_response = client.makePostRequest(client.createInvocationBuilder(path), new P_User(email, amount, concept)).readEntity(String.class);
		JSONParser myParser = new JSONParser();
		JSONObject myJsonObject = (JSONObject) myParser.parse(new_payment_response);
		operation_result = (boolean) myJsonObject.get("Result");

		return null;
	}

	@Override
	public boolean updateCurrency(String email, float amount) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long createUser(String nombre, String apellido, String email, float amount) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}