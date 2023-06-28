package e1;

import java.util.List;

public abstract class Operation implements SearchTicket {

    public SearchTicket searchCriteria1;
    public SearchTicket searchCriteria2;

    public abstract List<Ticket> findTickets(List<Ticket> tickets);

    public Operation(SearchTicket searchCriteria1, SearchTicket searchCriteria2) {
        this.searchCriteria1 = searchCriteria1;
        this.searchCriteria2 = searchCriteria2;
    }

    public Operation(SearchTicket searchCriteria1) {
        this.searchCriteria1 = searchCriteria1;
        this.searchCriteria2 = null;
    }
    public Operation(){}

    public void setSearchCriteria1(SearchTicket searchCriteria1) {
        this.searchCriteria1 = searchCriteria1;
    }

    public void setSearchCriteria2(SearchTicket searchCriteria2) {
        this.searchCriteria2 = searchCriteria2;
    }
}
