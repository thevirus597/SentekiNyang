package sr.unasat.sentekinyang.entities;

public class Restaurant {
    private int restaurant_id;
    private String restaurant_naam;

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurant_id=" + restaurant_id +
                ", restaurant_naam='" + restaurant_naam + '\'' +
                ", restaurant_adres='" + restaurant_adres + '\'' +
                ", restaurant_telefoon='" + restaurant_telefoon + '\'' +
                '}';
    }

    private String restaurant_adres;
    private String restaurant_telefoon;

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_naam() {
        return restaurant_naam;
    }

    public void setRestaurant_naam(String restaurant_naam) {
        this.restaurant_naam = restaurant_naam;
    }

    public String getRestaurant_adres() {
        return restaurant_adres;
    }

    public void setRestaurant_adres(String restaurant_adres) {
        this.restaurant_adres = restaurant_adres;
    }

    public String getRestaurant_telefoon() {
        return restaurant_telefoon;
    }

    public void setRestaurant_telefoon(String restaurant_telefoon) {
        this.restaurant_telefoon = restaurant_telefoon;
    }

    public Restaurant(int restaurant_id, String restaurant_naam, String restaurant_adres, String restaurant_telefoon) {
        this.restaurant_id = restaurant_id;
        this.restaurant_naam = restaurant_naam;
        this.restaurant_adres = restaurant_adres;
        this.restaurant_telefoon = restaurant_telefoon;
    }
}
