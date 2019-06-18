package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Klant;

import java.util.*;

import sr.unasat.sentekinyang.repositories.KlantRepository;
import sr.unasat.sentekinyang.repositories.OrderRepository;

public class Klanten {

    public void showKlantenOverview() {

        KlantRepository klantRepository = new KlantRepository();

        List<Klant> klantList = klantRepository.findAllKlanten();
        for (Klant klant : klantList) {
            System.out.println(klant);
        }
    }
}
