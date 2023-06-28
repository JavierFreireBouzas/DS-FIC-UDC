package e1;

import java.util.List;

public class Or extends Operation{

    @Override
    public List<Ticket> findTickets(List<Ticket> tickets) {
        List<Ticket> rtnList;
        rtnList = searchCriteria1.findTickets(tickets);
        if(searchCriteria2 != null)
            rtnList.addAll(searchCriteria2.findTickets(tickets));
        return rtnList;
    }

    public Or(SearchTicket searchCriteria1, SearchTicket searchCriteria2) {
        super(searchCriteria1, searchCriteria2);
    }

    public Or(SearchTicket searchCriteria1) {
        super(searchCriteria1);
    }

    public Or(){}
}
