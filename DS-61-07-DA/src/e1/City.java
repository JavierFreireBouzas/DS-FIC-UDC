package e1;

public class City {
    public String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return cityName;
    }
}
