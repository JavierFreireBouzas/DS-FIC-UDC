package e1;

import java.util.ArrayList;
import java.util.List;

public final class PriceSearch implements SearchTicket{

    private final double price;

    @Override
    public List<Ticket> findTickets(List<Ticket> tickets) {
        List<Ticket> foundTickets = new ArrayList<>();

        for (Ticket ticket : tickets){
            if(ticket.price <= price)
                foundTickets.add(ticket);
        }
        return foundTickets;
    }

    public PriceSearch(double price) {
        this.price = price;
    }
}
