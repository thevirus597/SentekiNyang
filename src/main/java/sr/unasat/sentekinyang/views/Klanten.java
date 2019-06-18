package sr.unasat.sentekinyang.views;
import sr.unasat.sentekinyang.entities.Klant;
import java.util.*;
import sr.unasat.sentekinyang.repositories.OrderRepository;

public class Klanten {

public void showKlantenOverview(){

    OrderRepository orderRepository = new OrderRepository();

    List<Klant> klantList = orderRepository.findAllKlanten();
      for (Klant klant : klantList) {
            System.out.println(klant);
       }
}
}
