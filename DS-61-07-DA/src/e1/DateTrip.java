package e1;

public class DateTrip {
    int day;
    int month;
    int year;

    public DateTrip(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return (day + "/" + month + "/" + year);
    }
}
