package src.server.gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import src.server.dto.Aeropuerto;
import src.server.dto.Vuelo;

public class AeroToSystem implements IGatewayAero{
	private static String path;
	static RestClient<Flight_parameters> client;
	List<Flight_JSON>vuelos;
	Response response;
	List<Flight_JSON> myFlightArray;
	String json_string;
	JSONParser myParser;
	JSONArray flightsArray;

	
	public AeroToSystem(String [] args) {
		client = new RestClient<>(args[3], args[6]);
		path = "/Airlines/Search_Flights";
	}


	@Override
	public List<Flight_JSON> getVuelos(Object [] args) throws Exception {
		if( args != null) {
			if(args.length==2)
			{
				vuelos = getVuelos((String) args[0], (String) args[1]);
			}
			else if(args.length==3)
			{
				vuelos = getVuelos((String) args[0], (String) args[1], (int) args[2]);
			}
			else if(args.length==4)
			{
				vuelos = getVuelos((String) args[0], (String) args[1], (int) args[2], (double) args[3]);
			}
			else if(args.length==5)
			{
				vuelos = getVuelos((String) args[0], (String) args[1], (int) args[2], (double) args[3], (String) args[4]);
			}
			else {
				throw new Exception();
			}
		}
		else
		{
			vuelos = getVuelos();
		}

		return vuelos;
	}
	
	public List<Flight_JSON> getVuelos() throws Exception {
		response = client.makePostRequest(client.createInvocationBuilder(path), new Flight_parameters());
		vuelos = flightParser(response);
		return vuelos;
	}
	
	public List<Flight_JSON> getVuelos(String airport_departure_name, String airport_arrival_name) throws Exception {
		response = client.makePostRequest(client.createInvocationBuilder(path), new Flight_parameters(airport_departure_name, airport_arrival_name));
		vuelos = flightParser(response);
		return vuelos;
	}
	
	public List<Flight_JSON> getVuelos(String airport_departure_name, String airport_arrival_name, int free_seats) throws Exception {
		response = client.makePostRequest(client.createInvocationBuilder(path), new Flight_parameters(airport_departure_name, airport_arrival_name, free_seats));
		vuelos = flightParser(response);
		return vuelos;
	}
	
	public List<Flight_JSON> getVuelos(String airport_departure_name, String airport_arrival_name, int free_seats, double price) throws Exception {
		response = client.makePostRequest(client.createInvocationBuilder(path), new Flight_parameters(airport_departure_name, airport_arrival_name, free_seats, price));
		vuelos = flightParser(response);
		return vuelos;
	}
	
	public List<Flight_JSON> getVuelos(String airport_departure_name, String airport_arrival_name, int free_seats, double price, String departure_date) throws Exception {
		response = client.makePostRequest(client.createInvocationBuilder(path), new Flight_parameters(airport_departure_name, airport_arrival_name, free_seats, price, departure_date));
		vuelos = flightParser(response);
		return vuelos;
	}
	
	@SuppressWarnings("unchecked")
	private List<Flight_JSON> flightParser(Response response) {
		myFlightArray = new ArrayList();
		
		try {
			json_string = response.readEntity(String.class);
			myParser = new JSONParser();
			flightsArray = (JSONArray) myParser.parse(json_string);
			myFlightArray = (List) flightsArray.stream().map(element->new Flight_JSON(element)).collect(Collectors.toList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return myFlightArray;
	}
	

}
