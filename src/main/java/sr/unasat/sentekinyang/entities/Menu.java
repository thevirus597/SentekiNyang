package sr.unasat.sentekinyang.entities;

public class Menu {
    private int menu_id;
    private int restaurant_id;
    private String menu_naam;
    private String restaurant_naam;
    private String restaurant_adres;
    private String restaurant_telefoon;
    private int prijs;

    @Override
    public String toString() {
        return "menu_id=" + menu_id +
                ", menu_naam='" + menu_naam + '\'' +
                ", restaurant_naam='" + restaurant_naam + '\'' +
                ", restaurant_adres='" + restaurant_adres + '\'' +
                ", restaurant_telefoon='" + restaurant_telefoon + '\'' +
                ", prijs=" + prijs;
    }

    public Menu(int menu_id, int restaurant_id, String menu_naam, String restaurant_naam, String restaurant_adres, String restaurant_telefoon, int prijs) {
        this.menu_id = menu_id;
        this.restaurant_id = restaurant_id;
        this.menu_naam = menu_naam;
        this.restaurant_naam = restaurant_naam;
        this.restaurant_adres = restaurant_adres;
        this.restaurant_telefoon = restaurant_telefoon;
        this.prijs = prijs;
    }

    public Menu(int menu_id, int restaurant_id, String menu_naam, int prijs) {
        this.menu_id = menu_id;
        this.restaurant_id = restaurant_id;
        this.menu_naam = menu_naam;
        this.prijs = prijs;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getMenu_naam() {
        return menu_naam;
    }

    public void setMenu_naam(String menu_naam) {
        this.menu_naam = menu_naam;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }
}
