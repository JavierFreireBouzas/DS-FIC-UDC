package e1;

import java.util.List;

public class TicketManager {

    private final List<Ticket> ticketList;

    /*
    addTicket and removeTicket are methods whose goal is to modify
    the list of all the available tickets (ticketList)
     */

    public void addTicket(Ticket ticket)
    {
        ticketList.add(ticket);
    }

    public void removeTicket(Ticket ticket)
    {
        if(ticketList.contains(ticket))
            ticketList.remove(ticket);
        else
            throw new IllegalArgumentException();
    }

    /*
    printAllTickets returns a String with all the available tickets in the database (ticketList)
     */

    public String printAllTickets()
    {
        int i;
        StringBuilder strList = new StringBuilder();
        if(ticketList.isEmpty()) return "No results for this search";
        for(i=0;i<ticketList.size();i++){
            strList.append(i+1).append(") Origin:").append(ticketList.get(i).origin)
                    .append(" Destination:").append(ticketList.get(i).destination).append(" Date:")
                    .append(ticketList.get(i).date).append(" Price:").append(ticketList.get(i).price)
                    .append(" Minutes:").append(ticketList.get(i).time)
                    .append(" Operator:").append(ticketList.get(i).operator)
                    .append(" Transfers:").append(ticketList.get(i).transfers).append("\n");
        }
        return strList.toString();
    }

    /*
    printFilteredTickets returns a String with the tickets that have been filtered (filteredList)
     */

    public String printFilteredTickets(List<Ticket> tickets)
    {
        int i;
        StringBuilder strList = new StringBuilder();
        if(tickets.isEmpty()) return "No results for this search";
        for(i=0;i<tickets.size();i++){
            strList.append(i+1).append(") Origin:").append(tickets.get(i).origin)
                    .append(" Destination:").append(tickets.get(i).destination).append(" Date:")
                    .append(tickets.get(i).date).append(" Price:").append(tickets.get(i).price)
                    .append(" Minutes:").append(tickets.get(i).time)
                    .append(" Operator:").append(tickets.get(i).operator)
                    .append(" Transfers:").append(tickets.get(i).transfers).append("\n");
        }
        return strList.toString();
    }

    public TicketManager(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }
}
