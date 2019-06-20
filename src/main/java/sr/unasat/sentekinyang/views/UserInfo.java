package sr.unasat.sentekinyang.views;

import java.util.Scanner;

import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.repositories.KlantRepository;

public class UserInfo {
    private Klant loggedInUser;
    char resume;

    public UserInfo(Klant loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    Scanner input = new Scanner(System.in);

    public void showUserInfo() {
        KlantRepository klantRepository = new KlantRepository();
        klantRepository.findUserByUsername(loggedInUser.getUsername());
        System.out.println("Naam: " + loggedInUser.getNaam());
        System.out.println("Adres: " + loggedInUser.getAdres());
        System.out.println("Telefoon: " + loggedInUser.getTelefoon());

        System.out.println("Wilt u verder gaan? (Y/N) ");
        resume = input.next().charAt(0);

        if (resume == 'y' || resume == 'Y') {
            MainMenu mainmenu = new MainMenu(loggedInUser);
            mainmenu.showMainMenu();
        }
    }

}
