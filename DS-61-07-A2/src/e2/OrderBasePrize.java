package e2;

import java.util.Comparator;

public class OrderBasePrize implements Comparator <Apartment>{
    @Override
    public int compare(Apartment ap1, Apartment ap2) {
        return Double.compare(ap1.basePrice, ap2.basePrice);
    }
}
