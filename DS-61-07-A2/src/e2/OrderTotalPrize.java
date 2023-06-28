package e2;

import java.util.Comparator;

public class OrderTotalPrize implements Comparator <Apartment> {
    @Override
    public int compare(Apartment ap1, Apartment ap2) {
        return Double.compare(ap1.totalPrice(), ap2.totalPrice());
    }
}
