package e1;

import java.util.ArrayList;
import java.util.List;

public final class DestinationSearch implements SearchTicket{

    private final City dest;

    @Override
    public List<Ticket> findTickets(List<Ticket> tickets) {
        List<Ticket> foundTickets = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if(ticket.destination == dest)
                foundTickets.add(ticket);
        }
        return foundTickets;
    }

    public DestinationSearch(City dest) {
        this.dest = dest;
    }
}
