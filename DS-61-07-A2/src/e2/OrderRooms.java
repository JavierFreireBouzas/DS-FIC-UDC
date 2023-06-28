package e2;

import java.util.Comparator;

public class OrderRooms implements Comparator <Apartment> {
    @Override
    public int compare(Apartment ap1, Apartment ap2) {
        return Integer.compare(ap1.rooms, ap2.rooms);
    }
}