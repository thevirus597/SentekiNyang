package sr.unasat.sentekinyang.entities;

public class Klant {
    private int klant_id;
    private String username;
    private String password;
    private String naam;
    private String adres;
    private boolean isLoggedIn = false;

    @Override
    public String toString() {
        return "klant_id=" + klant_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", naam='" + naam + '\'' +
                ", adres='" + adres + '\'' +
                ", isLoggedIn=" + isLoggedIn +
                ", telefoon='" + telefoon;
    }

    private String telefoon;

    public int getKlant_id() {
        return klant_id;
    }

    public void setKlant_id(int klant_id) {
        this.klant_id = klant_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Klant(int klant_id, String username, String password, String naam, String adres, String telefoon) {
        this.klant_id = klant_id;
        this.username = username;
        this.password = password;
        this.naam = naam;
        this.adres = adres;
        this.telefoon = telefoon;
    }

}
