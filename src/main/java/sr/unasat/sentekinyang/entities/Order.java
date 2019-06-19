package sr.unasat.sentekinyang.entities;

public class Order {
    private int order_id;
    private int klant_id;
    private int menu_id;
    private String restaurant;
    private String menu;
    private String klant_naam;
    private String klant_telefoon;
    private String levering_adres;
    private int levering_prijs;

    @Override
    public String toString() {
        return "order_id=" + order_id +
                ", restaurant='" + restaurant + '\'' +
                ", menu='" + menu + '\'' +
                ", klant_naam='" + klant_naam + '\'' +
                ", klant_telefoon='" + klant_telefoon + '\'' +
                ", levering_adres='" + levering_adres + '\'' +
                ", levering_prijs=" + levering_prijs;
    }

    public Order(int order_id, String restaurant, String menu, String klant_naam, String klant_telefoon, String levering_adres, int levering_prijs) {
        this.order_id = order_id;
        this.restaurant = restaurant;
        this.menu = menu;
        this.klant_naam = klant_naam;
        this.klant_telefoon = klant_telefoon;
        this.levering_adres = levering_adres;
        this.levering_prijs = levering_prijs;
    }

    public Order(int order_id, int klant_id, int menu_id, String levering_adres, int levering_prijs) {
        this.order_id = order_id;
        this.klant_id = klant_id;
        this.menu_id = menu_id;
        this.levering_adres = levering_adres;
        this.levering_prijs = levering_prijs;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getKlant_id() {
        return klant_id;
    }

    public void setKlant_id(int klant_id) {
        this.klant_id = klant_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getLevering_adres() {
        return levering_adres;
    }

    public void setLevering_adres(String levering_adres) {
        this.levering_adres = levering_adres;
    }

    public int getLevering_prijs() {
        return levering_prijs;
    }

    public void setLevering_prijs(int levering_prijs) {
        this.levering_prijs = levering_prijs;
    }
}