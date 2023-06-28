package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {

    private Apartment apart1 , apart2, apart3, apart4;
    ArrayList<Double> park1, park2, park3, park4;
    private ManageApartm manager;

    @BeforeEach
    void setUp() {
        park1 = new ArrayList<>();
        park2 = new ArrayList<>();
        park3 = new ArrayList<>();
        park4 = new ArrayList<>();
        park1.add(8000.0);
        park1.add(11000.0);
        apart1 = new Apartment(123, 125000.0, 120, 36600, 4, 2, 1, true, true, false, park1);
        park2.add(23000.0);
        apart2 = new Apartment(512, 250000.0, 155, 15180, 6, 3, 3, true, true, true, park2);
        apart3 = new Apartment(110, 180000.0, 200, 24400, 3, 1, 1, true, true, true, park3);
        park4.add(8000.0);
        park4.add(11000.0);
        apart4 = new Apartment(222, 125000.0, 120, 36600, 4, 2, 1, true, true, false, park4);
        manager = new ManageApartm();
    }

    @Test
    void parkingPrize() {
        assertEquals(19000.0, apart1.parkingPrize());
        assertEquals(23000.0, apart2.parkingPrize());
        assertEquals(0.0, apart3.parkingPrize());
        assertEquals(19000.0, apart4.parkingPrize());

    }

    @Test
    void parkingSpaces() {
        assertEquals(2, apart1.parkingSpaces());
        assertEquals(1, apart2.parkingSpaces());
        assertEquals(0, apart3.parkingSpaces());
        assertEquals(2, apart4.parkingSpaces());
    }

    @Test
    void totalPrice() {
        assertEquals(144000.0, apart1.totalPrice());
        assertEquals(273000.0, apart2.totalPrice());
        assertEquals(180000.0, apart3.totalPrice());
        assertEquals(144000.0, apart4.totalPrice());
    }

    @Test
    void testEquals() {
        assertNotEquals(apart1, apart2);
        assertNotEquals(apart1, apart3);
        assertNotEquals(apart2, apart3);
        assertEquals(apart1, apart4);
    }

    @Test
    void testHashCode() {
        assertNotEquals(apart1.hashCode(), apart2.hashCode());
        assertNotEquals(apart1.hashCode(), apart3.hashCode());
        assertNotEquals(apart2.hashCode(), apart3.hashCode());
        assertEquals(apart1.hashCode(), apart4.hashCode());
    }

    @Test
    void testSimilarParking(){
        Apartment apart5 , apart6;
        ArrayList<Double> park5, park6;
        park5 = new ArrayList<>();
        park6 = new ArrayList<>();
        park5.add(10000.0);
        park5.add(10000.0);
        park5.add(10000.0);
        park6.add(15000.0);
        park6.add(5000.0);
        park6.add(10000.0);
        apart5 = new Apartment(345, 165000.0, 190, 67800, 4, 3, 5, false, true, false, park5);
        apart6 = new Apartment(985, 165000.0, 190, 67800, 4, 3, 5, false, true, false, park6);
        assertNotEquals(apart5,apart6);

    }

    @Test
    void compareTo() {
        assertEquals(-1, apart1.compareTo(apart2));
        assertEquals(1, apart1.compareTo(apart3));
        assertEquals(-1, apart1.compareTo(apart4));
        assertEquals(1, apart2.compareTo(apart3));
        assertEquals(1, apart2.compareTo(apart4));
        assertEquals(-1, apart3.compareTo(apart4));
    }

    @Test
    void checkManageApartm() {
        //test addApartm
        manager.addApartm(apart1);
        manager.addApartm(apart2);
        manager.addApartm(apart3);
        manager.addApartm(apart4);
        assertEquals(4, manager.listApart.size());

        //check order
        //it orders form the smallest to the biggest

        manager.orderApartm();
        assertEquals(apart3,manager.listApart.get(0));
        assertEquals(apart1,manager.listApart.get(1));
        assertEquals(apart4,manager.listApart.get(2));
        assertEquals(apart2,manager.listApart.get(3));

        manager.setCriterion(new OrderBasePrize());
        manager.orderApartm();
        assertEquals(apart1,manager.listApart.get(0));
        assertEquals(apart4,manager.listApart.get(0));
        assertEquals(apart4,manager.listApart.get(1));
        assertEquals(apart1,manager.listApart.get(1));
        assertEquals(apart3,manager.listApart.get(2));
        assertEquals(apart2,manager.listApart.get(3));

        manager.setCriterion(new OrderRooms());
        manager.orderApartm();
        assertEquals(apart3,manager.listApart.get(0));
        assertEquals(apart1,manager.listApart.get(1));
        assertEquals(apart4,manager.listApart.get(1));
        assertEquals(apart1,manager.listApart.get(2));
        assertEquals(apart4,manager.listApart.get(2));
        assertEquals(apart2,manager.listApart.get(3));

        manager.setCriterion(new OrderSize());
        manager.orderApartm();
        assertEquals(apart1,manager.listApart.get(0));
        assertEquals(apart4,manager.listApart.get(0));
        assertEquals(apart4,manager.listApart.get(1));
        assertEquals(apart1,manager.listApart.get(1));
        assertEquals(apart2,manager.listApart.get(2));
        assertEquals(apart3,manager.listApart.get(3));

        manager.setCriterion(new OrderTotalPrize());
        manager.orderApartm();
        assertEquals(apart1,manager.listApart.get(0));
        assertEquals(apart4,manager.listApart.get(0));
        assertEquals(apart4,manager.listApart.get(1));
        assertEquals(apart1,manager.listApart.get(1));
        assertEquals(apart3,manager.listApart.get(2));
        assertEquals(apart2,manager.listApart.get(3));

    }

}