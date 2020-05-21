package src.server.dto;

import java.util.ArrayList;
import java.util.List;

import src.server.gateway.Flight_JSON;


public class VueloAssembler {

	public static ArrayList<Vuelo> assemble(List<Flight_JSON> vuelosJSON)
	{
		ArrayList<Vuelo> vuelos = new ArrayList<>();

		for (Flight_JSON t : vuelosJSON) 
		{
			vuelos.add(new Vuelo(t.getCode(), t.getPrice(), t.getTotalSeats(), t.getFreeSeats(), t.getDepartureDate(), t.getDepartureDate(true), new Aeropuerto(t.getAirportDepartureCode(), t.getAirportDepartureCity()), new Aeropuerto(t.getAirportArrivalCode(), t.getAirportArrivalCity()), null));
		}

		System.out.println("* Assembling TV Programs ...");
		
		return vuelos;
	}
}

