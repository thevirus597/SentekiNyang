package sr.unasat.sentekinyang.entities;

public class Klant {
    private int klant_id;
    private String naam;
    private String adres;

    @Override
    public String toString() {
        return "Klant{" +
                "klant_id=" + klant_id +
                ", naam='" + naam + '\'' +
                ", adres='" + adres + '\'' +
                ", telefoon='" + telefoon + '\'' +
                '}';
    }

    private String telefoon;

    public int getKlant_id() {
        return klant_id;
    }

    public void setKlant_id(int klant_id) {
        this.klant_id = klant_id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public Klant(int klant_id, String naam, String adres, String telefoon) {
        this.klant_id = klant_id;
        this.naam = naam;
        this.adres = adres;
        this.telefoon = telefoon;
    }

}
