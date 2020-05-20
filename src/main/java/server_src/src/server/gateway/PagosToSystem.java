package src.server.gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import src.server.gateway.P_User;
import src.server.gateway.RestClient;
import src.server.dto.Persona;

public class PagosToSystem implements IGatewayPagos{


  	private RestClient<P_User> client;
	private String path;
	
	public PagosToSystem(String[] args) {
		client = new RestClient<>(args[3], args[5]);
	//	client = new RestClient<>("192.168.6.31", "5001");
	}
	
	@Override
	public String makePayment(String email, float amount, String concept) throws Exception {
		// Metodo que devuelve el recibo con su id correspondiente. No devuelve un booleano.
		path = "/Payments/Make_payment";
		String new_payment_response;

		new_payment_response = client.makePostRequest(client.createInvocationBuilder(path), new P_User(email, amount, concept)).readEntity(String.class);

		return new_payment_response;
	}

	@Override
	public boolean updateCurrency(String email, float amount) throws Exception {
		path = "/Payments/Update_currency";
		boolean operation_result = false;
		String update_currency_response;
		
		update_currency_response = client.makePutRequest(client.createInvocationBuilder(path), new P_User(email, amount)).readEntity(String.class);
		JSONParser myParser = new JSONParser();
		JSONObject myJsonObject = (JSONObject) myParser.parse(update_currency_response);
		operation_result = (boolean) myJsonObject.get("Result");
		
		return operation_result;
	}

	@Override
	public boolean createUser(String nombre, String apellido, String email, float amount) throws Exception {
		path = "/Payments/Create_user";
		boolean operation_result = false;
		String user_creation_response;
		
		user_creation_response = client.makePostRequest(client.createInvocationBuilder(path), new P_User(nombre, apellido, email, amount)).readEntity(String.class);
		JSONParser myParser = new JSONParser();
		JSONObject myJsonObject = (JSONObject) myParser.parse(user_creation_response);
		operation_result = (boolean) myJsonObject.get("Result");
		
		return operation_result;
		
	}


}