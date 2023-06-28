package e2;

import java.util.ArrayList;
import java.util.Objects;

public class Apartment implements Comparable<Apartment>{
    double basePrice;
    int size, postCode, rooms, baths, floor, refNum;
    boolean wifi, tv, elevator;
    ArrayList<Double> parking;

    public Apartment(int refNum, double basePrice, int size, int postCode, int rooms, int baths, int floor, boolean wifi, boolean tv, boolean elevator, ArrayList<Double> parking) {
        this.refNum = refNum;
        this.basePrice = basePrice;
        this.size = size;
        this.postCode = postCode;
        this.rooms = rooms;
        this.baths = baths;
        this.floor = floor;
        this.wifi = wifi;
        this.tv = tv;
        this.elevator = elevator;
        this.parking = parking;
    }
    public double parkingPrize(){
        double prize = 0.0;
        for (Double i : parking) {
            prize += i;
        }
        return prize;
    }

    public int parkingSpaces(){
        return parking.size();
    }

    public double totalPrice(){
        return (basePrice + parkingPrize());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        if(Double.compare(apartment.basePrice, basePrice) != 0) return false;
        if(size != apartment.size) return false;
        if(postCode != apartment.postCode) return false;
        if(rooms != apartment.rooms) return false;
        if(baths != apartment.baths) return false;
        if(floor != apartment.floor) return false;
        if(wifi != apartment.wifi) return false;
        if(tv != apartment.tv) return false;
        if(elevator != apartment.elevator) return false;
        if(parkingSpaces() != apartment.parkingSpaces()) return false;
        if (parkingPrize() != apartment.parkingPrize()) return false;
        apartment.parking.sort(null);
        parking.sort(null);
        for(int i = 0; i < parking.size(); i++){
            if(!Objects.equals(apartment.parking.get(i), parking.get(i)))
                return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(basePrice, size, postCode, rooms, baths, floor, wifi, tv, elevator);
    }

    @Override
    public int compareTo(Apartment ap) {
        return Integer.compare(this.refNum, ap.refNum);
    }

}
