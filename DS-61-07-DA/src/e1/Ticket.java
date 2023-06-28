package e1;

public class Ticket {

    public City origin;
    public City destination;
    public double price;
    public DateTrip date;
    public int time;
    public String operator;
    public boolean transfers;

    public Ticket(City origin, City destination, double price, DateTrip date, int time, String operator, boolean transfers) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.date = date;
        this.time = time;
        this.operator = operator;
        this.transfers = transfers;
    }
}
