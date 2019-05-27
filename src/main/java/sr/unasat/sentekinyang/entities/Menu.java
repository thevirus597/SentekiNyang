package sr.unasat.sentekinyang.entities;

public class Menu {
    private int menu_id;
    private int restaurant_id;
    private String menu_naam;
    private int prijs;

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", restaurant_id=" + restaurant_id +
                ", menu_naam='" + menu_naam + '\'' +
                ", prijs=" + prijs +
                '}';
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
