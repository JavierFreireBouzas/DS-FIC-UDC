package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    City Vigo = new City("Vigo");
    City Carballo = new City("Carballo");
    City Vilagarcia = new City("Vilagarcia");
    City Pontevedra = new City("Pontevedra");
    City Ourense = new City("Ourense");
    City Lugo = new City("Lugo");
    City Oleiros = new City("Oleiros");
    City Ferrol = new City("Ferrol");
    City Santiago = new City("Santiago");

    DateTrip date1 = new DateTrip(30,11,2021);
    DateTrip date2 = new DateTrip(11,1,2022);
    DateTrip date3 = new DateTrip(3,9,2022);
    DateTrip date4 = new DateTrip(12,8,2032);
    DateTrip date5 = new DateTrip(5,6,2025);
    DateTrip date6 = new DateTrip(20,12,2021);
    DateTrip date7 = new DateTrip(31,1,2021);

    Ticket ticket1 = new Ticket(Carballo,Vilagarcia, 8.60, date1, 70, "Alsa", true);
    Ticket ticket2 = new Ticket(Vigo,Ourense, 12.50, date2, 120, "Monbus", false);
    Ticket ticket3 = new Ticket(Ferrol,Oleiros, 4.15, date3, 35, "Tranvias", true);
    Ticket ticket4 = new Ticket(Santiago,Pontevedra, 7.75, date4, 60, "Alsa", false);
    Ticket ticket5 = new Ticket(Lugo,Vilagarcia, 10.30, date5, 160, "Pereira", true);
    Ticket ticket6 = new Ticket(Lugo,Vilagarcia, 9.50, date1, 130, "Monbus", false);
    Ticket ticket7 = new Ticket(Carballo,Oleiros, 6.15, date6, 40, "Alsa", false);
    Ticket ticket8 = new Ticket(Carballo,Oleiros, 8.15, date6, 70, "Monbus", true);
    Ticket ticket9 = new Ticket(Vigo,Lugo, 17.60, date7, 200, "Alsa", false);
    Ticket ticket10 = new Ticket(Oleiros, Ferrol, 1.45, date2, 40, "Tranvias", false);

    List<Ticket> listOfTickets = new ArrayList<>();

    TicketManager manager = new TicketManager(listOfTickets);

    @BeforeEach
    void setUp() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);

        manager.removeTicket(ticket1);
        manager.removeTicket(ticket2);
    }

    @Test
    void addRemoveTest(){
        assertEquals("""
                1) Origin:Ferrol Destination:Oleiros Date:3/9/2022 Price:4.15 Minutes:35 Operator:Tranvias Transfers:true
                2) Origin:Santiago Destination:Pontevedra Date:12/8/2032 Price:7.75 Minutes:60 Operator:Alsa Transfers:false
                3) Origin:Lugo Destination:Vilagarcia Date:5/6/2025 Price:10.3 Minutes:160 Operator:Pereira Transfers:true
                4) Origin:Lugo Destination:Vilagarcia Date:30/11/2021 Price:9.5 Minutes:130 Operator:Monbus Transfers:false
                5) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:6.15 Minutes:40 Operator:Alsa Transfers:false
                6) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:8.15 Minutes:70 Operator:Monbus Transfers:true
                7) Origin:Vigo Destination:Lugo Date:31/1/2021 Price:17.6 Minutes:200 Operator:Alsa Transfers:false
                8) Origin:Oleiros Destination:Ferrol Date:11/1/2022 Price:1.45 Minutes:40 Operator:Tranvias Transfers:false
                """,manager.printAllTickets());
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        assertEquals("""
                1) Origin:Ferrol Destination:Oleiros Date:3/9/2022 Price:4.15 Minutes:35 Operator:Tranvias Transfers:true
                2) Origin:Santiago Destination:Pontevedra Date:12/8/2032 Price:7.75 Minutes:60 Operator:Alsa Transfers:false
                3) Origin:Lugo Destination:Vilagarcia Date:5/6/2025 Price:10.3 Minutes:160 Operator:Pereira Transfers:true
                4) Origin:Lugo Destination:Vilagarcia Date:30/11/2021 Price:9.5 Minutes:130 Operator:Monbus Transfers:false
                5) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:6.15 Minutes:40 Operator:Alsa Transfers:false
                6) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:8.15 Minutes:70 Operator:Monbus Transfers:true
                7) Origin:Vigo Destination:Lugo Date:31/1/2021 Price:17.6 Minutes:200 Operator:Alsa Transfers:false
                8) Origin:Oleiros Destination:Ferrol Date:11/1/2022 Price:1.45 Minutes:40 Operator:Tranvias Transfers:false
                9) Origin:Carballo Destination:Vilagarcia Date:30/11/2021 Price:8.6 Minutes:70 Operator:Alsa Transfers:true
                10) Origin:Vigo Destination:Ourense Date:11/1/2022 Price:12.5 Minutes:120 Operator:Monbus Transfers:false
                """,manager.printAllTickets());
        manager.removeTicket(ticket4);
        assertEquals("""
                1) Origin:Ferrol Destination:Oleiros Date:3/9/2022 Price:4.15 Minutes:35 Operator:Tranvias Transfers:true
                2) Origin:Lugo Destination:Vilagarcia Date:5/6/2025 Price:10.3 Minutes:160 Operator:Pereira Transfers:true
                3) Origin:Lugo Destination:Vilagarcia Date:30/11/2021 Price:9.5 Minutes:130 Operator:Monbus Transfers:false
                4) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:6.15 Minutes:40 Operator:Alsa Transfers:false
                5) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:8.15 Minutes:70 Operator:Monbus Transfers:true
                6) Origin:Vigo Destination:Lugo Date:31/1/2021 Price:17.6 Minutes:200 Operator:Alsa Transfers:false
                7) Origin:Oleiros Destination:Ferrol Date:11/1/2022 Price:1.45 Minutes:40 Operator:Tranvias Transfers:false
                8) Origin:Carballo Destination:Vilagarcia Date:30/11/2021 Price:8.6 Minutes:70 Operator:Alsa Transfers:true
                9) Origin:Vigo Destination:Ourense Date:11/1/2022 Price:12.5 Minutes:120 Operator:Monbus Transfers:false
                """,manager.printAllTickets());
        assertThrows(IllegalArgumentException.class, () -> manager.removeTicket(ticket4));
    }

    @Test
    void simpleFilterTest(){
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);

        Operation operator;
        operator = new And(new OriginSearch(Oleiros));
        assertEquals("""
                1) Origin:Oleiros Destination:Ferrol Date:11/1/2022 Price:1.45 Minutes:40 Operator:Tranvias Transfers:false
                """,manager.printFilteredTickets(operator.findTickets(manager.getTicketList())));

        operator.setSearchCriteria1(new DestinationSearch(Vilagarcia));
        assertEquals("""
                1) Origin:Lugo Destination:Vilagarcia Date:5/6/2025 Price:10.3 Minutes:160 Operator:Pereira Transfers:true
                2) Origin:Lugo Destination:Vilagarcia Date:30/11/2021 Price:9.5 Minutes:130 Operator:Monbus Transfers:false
                3) Origin:Carballo Destination:Vilagarcia Date:30/11/2021 Price:8.6 Minutes:70 Operator:Alsa Transfers:true
                """,manager.printFilteredTickets(operator.findTickets(manager.getTicketList())));

        operator.setSearchCriteria1(new PriceSearch(8.0));
        assertEquals("""
                1) Origin:Ferrol Destination:Oleiros Date:3/9/2022 Price:4.15 Minutes:35 Operator:Tranvias Transfers:true
                2) Origin:Santiago Destination:Pontevedra Date:12/8/2032 Price:7.75 Minutes:60 Operator:Alsa Transfers:false
                3) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:6.15 Minutes:40 Operator:Alsa Transfers:false
                4) Origin:Oleiros Destination:Ferrol Date:11/1/2022 Price:1.45 Minutes:40 Operator:Tranvias Transfers:false
                """,manager.printFilteredTickets(operator.findTickets(manager.getTicketList())));

        operator.setSearchCriteria1(new DateSearch(date1));
        assertEquals("""
                1) Origin:Lugo Destination:Vilagarcia Date:30/11/2021 Price:9.5 Minutes:130 Operator:Monbus Transfers:false
                2) Origin:Carballo Destination:Vilagarcia Date:30/11/2021 Price:8.6 Minutes:70 Operator:Alsa Transfers:true
                """,manager.printFilteredTickets(operator.findTickets(manager.getTicketList())));
    }

    @Test
    void filterTest(){
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);

        Operation operatorAND = new And();
        operatorAND.setSearchCriteria1(new PriceSearch(8.0));
        operatorAND.setSearchCriteria2(new DestinationSearch(Oleiros));
        assertEquals("""
                1) Origin:Ferrol Destination:Oleiros Date:3/9/2022 Price:4.15 Minutes:35 Operator:Tranvias Transfers:true
                2) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:6.15 Minutes:40 Operator:Alsa Transfers:false
                """,manager.printFilteredTickets(operatorAND.findTickets(manager.getTicketList())));

        Operation operatorOR = new Or();
        operatorOR.setSearchCriteria1(new OriginSearch(Ferrol));
        operatorOR.setSearchCriteria2(new OriginSearch(Vigo));
        assertEquals("""
                1) Origin:Ferrol Destination:Oleiros Date:3/9/2022 Price:4.15 Minutes:35 Operator:Tranvias Transfers:true
                2) Origin:Vigo Destination:Lugo Date:31/1/2021 Price:17.6 Minutes:200 Operator:Alsa Transfers:false
                3) Origin:Vigo Destination:Ourense Date:11/1/2022 Price:12.5 Minutes:120 Operator:Monbus Transfers:false
                """,manager.printFilteredTickets(operatorOR.findTickets(manager.getTicketList())));

        operatorAND.setSearchCriteria1(new OriginSearch(Santiago));
        operatorAND.setSearchCriteria2(new OriginSearch(Carballo));
        assertEquals("No results for this search",manager.printFilteredTickets(operatorAND.findTickets(manager.getTicketList())));
    }

    @Test
    void realCaseTest(){
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);

        Operation operatorOR = new Or(new OriginSearch(Lugo), new OriginSearch(Carballo));
        assertEquals("""
                1) Origin:Lugo Destination:Vilagarcia Date:5/6/2025 Price:10.3 Minutes:160 Operator:Pereira Transfers:true
                2) Origin:Lugo Destination:Vilagarcia Date:30/11/2021 Price:9.5 Minutes:130 Operator:Monbus Transfers:false
                3) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:6.15 Minutes:40 Operator:Alsa Transfers:false
                4) Origin:Carballo Destination:Oleiros Date:20/12/2021 Price:8.15 Minutes:70 Operator:Monbus Transfers:true
                5) Origin:Carballo Destination:Vilagarcia Date:30/11/2021 Price:8.6 Minutes:70 Operator:Alsa Transfers:true
                """,manager.printFilteredTickets(operatorOR.findTickets(manager.getTicketList())));

        Operation operatorAND = new And(new DestinationSearch(Vilagarcia), new DateSearch(date1));
        Operation operator = new And(operatorAND, operatorOR);
        assertEquals("""
                1) Origin:Lugo Destination:Vilagarcia Date:30/11/2021 Price:9.5 Minutes:130 Operator:Monbus Transfers:false
                2) Origin:Carballo Destination:Vilagarcia Date:30/11/2021 Price:8.6 Minutes:70 Operator:Alsa Transfers:true
                """,manager.printFilteredTickets(operator.findTickets(manager.getTicketList())));

        operator.setSearchCriteria1(new And(operatorAND, operatorOR));
        operator.setSearchCriteria2(new PriceSearch(9));
        assertEquals("""
                1) Origin:Carballo Destination:Vilagarcia Date:30/11/2021 Price:8.6 Minutes:70 Operator:Alsa Transfers:true
                """,manager.printFilteredTickets(operator.findTickets(manager.getTicketList())));

    }
}