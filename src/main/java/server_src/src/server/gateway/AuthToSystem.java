package src.server.gateway;

import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class AuthToSystem implements IGatewayAuth{

	private RestClient<A_User> client;
	private String path;
	
	public AuthToSystem(String[] args) {
		 client = new RestClient<>(args[3], args[4]);
		//client = new RestClient<>("192.168.6.31", "5000");
	}
	
	@Override
	public boolean LogIn(String email, String password) throws Exception {
		path = "/Authentication/Log_in";
		boolean operation_result = false;
		String new_login_response;

		new_login_response = client.makePostRequest(client.createInvocationBuilder(path), new A_User(email, password)).readEntity(String.class);
		JSONParser myParser = new JSONParser();
		JSONObject myJsonObject = (JSONObject) myParser.parse(new_login_response);
		operation_result = (boolean) myJsonObject.get("Result");

		return operation_result;
	}

	@Override
	public long createUser(String nombre, String apellido, String email) throws Exception {
		path = "/Authentication/Create_user";
		Response response = null;
			
		response = client.makePostRequest(client.createInvocationBuilder(path), new A_User(nombre, apellido, email));
		
		Simple_pass_result result_class_password = null;
		String reply = response.readEntity(String.class);
		
	
		result_class_password = new Simple_pass_result(reply);

		long password = result_class_password.getContentNumber();
		return password;
	}

	@Override
	public boolean changePassword(String email, String passOld, String passNew) throws Exception {
		path = "/Authentication/Change_password";
		boolean operation_result = false;
		String change_password_response;

		change_password_response = client.makePutRequest(client.createInvocationBuilder(path), new A_User(null, null, email, passOld, passNew)).readEntity(String.class);
		JSONParser myParser = new JSONParser();
		JSONObject myJsonObject = (JSONObject) myParser.parse(change_password_response);
		operation_result = (boolean) myJsonObject.get("Result");
	
		return operation_result;

	}

	@Override
	public boolean deleteUser(String email, String password) throws Exception {
		path = "/Authentication/Delete_user";
		boolean operation_result = false;
		String delete_response;
		
		delete_response = client.makePutRequest(client.createInvocationBuilder(path), new A_User(email, password)).readEntity(String.class);
		JSONParser myParser = new JSONParser();
		JSONObject myJsonObject = (JSONObject) myParser.parse(delete_response);
		operation_result = (boolean) myJsonObject.get("Result");

		return operation_result;

	}

}
