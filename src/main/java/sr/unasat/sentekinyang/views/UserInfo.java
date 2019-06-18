package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.repositories.KlantRepository;

public class UserInfo {
    private Klant loggedInUser;

    public UserInfo(Klant loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void showUserInfo(){
        KlantRepository klantRepository = new KlantRepository();
        klantRepository.findUserByUsername(loggedInUser.getUsername());
        System.out.println("Naam: "+ loggedInUser.getNaam());
        System.out.println("Adres: "+ loggedInUser.getAdres());
        System.out.println("Telefoon: "+ loggedInUser.getTelefoon());
    }
}
