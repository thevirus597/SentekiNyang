package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Klant;

import java.util.*;
import java.util.Scanner;

import sr.unasat.sentekinyang.repositories.KlantRepository;
import sr.unasat.sentekinyang.repositories.OrderRepository;

public class Klanten {
    private Klant loggedInUser;
    char resume;
    public void showKlantenOverview() {
        Scanner input = new Scanner(System.in);

        KlantRepository klantRepository = new KlantRepository();

        List<Klant> klantList = klantRepository.findAllKlanten();
        for (Klant klant : klantList) {
            System.out.println(klant);
            System.out.println("Wilt u verder gaan? (Y/N) ");
            resume = input.next().charAt(0);

            if (resume == 'y' || resume == 'Y') {
                MainMenu mainmenu = new MainMenu(loggedInUser);
                mainmenu.showMainMenu();
            }
        }

    }

}
