package src.server.gateway;

public class Flight_parameters  implements DF_Printable{
    private String airport_departure_name;
    private String airport_arrival_name;
    private int free_seats;
    private double price;
    private String departure_date;

    public Flight_parameters() {
    }

    public Flight_parameters(String airport_departure_name, String airport_arrival_name) {
        this.airport_departure_name = airport_departure_name;
        this.airport_arrival_name = airport_arrival_name;
    }

    public Flight_parameters(String airport_departure_name, String airport_arrival_name, int free_seats) {
        this.airport_departure_name = airport_departure_name;
        this.airport_arrival_name = airport_arrival_name;
        this.free_seats = free_seats;
    }


    public Flight_parameters(String airport_departure_name, String airport_arrival_name, String departure_date) {
        this.airport_departure_name = airport_departure_name;
        this.airport_arrival_name = airport_arrival_name;
        
    }

    public Flight_parameters(String airport_departure_name, String airport_arrival_name, int free_seats, String departure_date) {
        this.airport_departure_name = airport_departure_name;
        this.airport_arrival_name = airport_arrival_name;
        this.free_seats = free_seats;
        this.departure_date = departure_date;
    }

    public String getAirport_departure_name() {
        return airport_departure_name;
    }

    public void setAirport_departure_name(String airport_departure_name) {
        this.airport_departure_name = airport_departure_name;
    }

    public String getAirport_arrival_name() {
        return airport_arrival_name;
    }

    public void setAirport_arrival_name(String airport_arrival_name) {
        this.airport_arrival_name = airport_arrival_name;
    }

    public int getFree_seats() {
        return free_seats;
    }

    public void setFree_seats(int free_seats) {
        this.free_seats = free_seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeparture_date() {
        return this.departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public void print()
    {
        System.out.println(
                "Printing Flight_parameters" + "\n" +
                 "Airport_departure_name: " + getAirport_departure_name() + "\n" +
                 "Airport_arrival_name: " + getAirport_arrival_name() + "\n" +
                 "free_seats: " + getFree_seats() + "\n" +
                 "Price: " + getPrice() + "\n" +
                 "Departure_date: " + getDeparture_date() + "\n"
        );
    }
}

