package src.server.gateway;

public class P_User implements DF_Printable
{
    private String name;
    private String last_name;
    private String email;
    private double total_amount;
    private String concept;
    private double currency;

    public P_User(String name, String last_name, String email, double total_amount, String concept, double currency) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.total_amount = total_amount;
        this.concept = concept;
        this.currency = currency;
    }

    public P_User(String email, double total_amount, String concept) {
        this.email = email;
        this.total_amount = total_amount;
        this.concept = concept;
    }


    public P_User(String name, String last_name, String email, double currency) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.currency = currency;
    }

    public P_User(String email, double currency) {
        this.email = email;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    @Override
    public void print()
    {
        System.out.println(
                "Printing P_User" + "\n" +
                "Name: " + getName() + "\n" +
                "Last name: " + getLast_name() + "\n" +
                "email: " + getEmail() + "\n" +
                "Total_amount: " + getTotal_amount() + "\n" +
                "Concept:" + getConcept() + "\n" +
                "Currency:" + getCurrency() + "\n"
        );
    }
}