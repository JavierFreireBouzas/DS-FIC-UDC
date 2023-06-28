package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageApartm {
    ArrayList<Apartment> listApart = new ArrayList<>();
    Comparator <Apartment> criterion = null;

    public void setCriterion(Comparator<Apartment> criterion) {
        this.criterion = criterion;
    }

    public void addApartm(Apartment newApart){
        listApart.add(newApart);
    }

    public void orderApartm(){
        if(criterion == null)
            Collections.sort(listApart);
        else
            listApart.sort(criterion);
    }
}
