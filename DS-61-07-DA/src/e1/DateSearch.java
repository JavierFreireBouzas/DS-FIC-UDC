package e1;

import java.util.ArrayList;
import java.util.List;

public final class DateSearch implements SearchTicket{

    private final DateTrip date;

    @Override
    public List<Ticket> findTickets(List<Ticket> tickets) {
        List<Ticket> foundTickets = new ArrayList<>();

        for (Ticket ticket : tickets){
            if(ticket.date == date)
                foundTickets.add(ticket);
        }
        return foundTickets;
    }

    public DateSearch(DateTrip date) {
        this.date = date;
    }
}