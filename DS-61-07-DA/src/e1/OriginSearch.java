package e1;

import java.util.ArrayList;
import java.util.List;

public final class OriginSearch implements SearchTicket{

    private final City origin;

    @Override
    public List<Ticket> findTickets(List<Ticket> tickets) {
        List<Ticket> foundTickets = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if(ticket.origin == origin)
                foundTickets.add(ticket);
        }
        return foundTickets;
    }

    public OriginSearch(City origin) {
        this.origin = origin;
    }
}
