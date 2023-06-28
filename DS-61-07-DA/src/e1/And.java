package e1;

import java.util.List;

public class And extends Operation{

    @Override
    public List<Ticket> findTickets(List<Ticket> tickets) {
        List<Ticket> rtnList;
        rtnList = searchCriteria1.findTickets(tickets);
        if(searchCriteria2 != null)
            rtnList = searchCriteria2.findTickets(rtnList);
        return rtnList;
    }

    public And(SearchTicket searchCriteria1, SearchTicket searchCriteria2) {
        super(searchCriteria1, searchCriteria2);
    }

    public And(SearchTicket searchCriteria1) {
        super(searchCriteria1);
    }
    public And(){}


}
