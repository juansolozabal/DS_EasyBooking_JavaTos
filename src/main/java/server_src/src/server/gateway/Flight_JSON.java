package src.server.gateway;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import org.json.simple.JSONObject;

public class Flight_JSON {
    JSONObject json_encoded;

    public Flight_JSON(Object json_encoded)
    {
        this.json_encoded = (JSONObject) json_encoded;
    }

    public void print()
    {
        System.out.println(json_encoded.toJSONString());
    }


    public String getCode()
    {
        return (String) json_encoded.get("_Flight__code");
    }

    public long getPrice()
    {
        return (long) json_encoded.get("_Flight__price");
    }

    public long getFreeSeats()
    {
        return (long) json_encoded.get("_Flight__free_seats");
    }

    public long getTotalSeats()
    {
        return (long) json_encoded.get("_Flight__total_seats");
    }

    public String getAirportArrivalCity()
    {
        return (String) ((JSONObject)json_encoded.get("_Flight__airport_arrival")).get("_Airport__city");
    }

    public String getAirportArrivalCode()
    {
        return (String) ((JSONObject)json_encoded.get("_Flight__airport_arrival")).get("_Airport__code");
    }

    public String getAirportDepartureCity()
    {
        return (String) ((JSONObject)json_encoded.get("_Flight__airport_departure")).get("_Airport__city");
    }

    public String getAirportDepartureCode()
    {
        return (String) ((JSONObject)json_encoded.get("_Flight__airport_departure")).get("_Airport__code");
    }

    public String getDepartureDate()
    {
        return (String) json_encoded.get("_Flight__departure_date");
    }

    public LocalDateTime getDepartureDate(boolean withHours )
    {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd [[HH][:mm][:ss]]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .toFormatter();

        return LocalDateTime.parse(getDepartureDate().split("\\.")[0], formatter); // get rid of milliseconds

        // with hours -> change print format -> departure_date.format(formatter_new);



    }

}

