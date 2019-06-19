package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.entities.Order;
import sr.unasat.sentekinyang.repositories.OrderRepository;


import java.util.List;

public class OrderHistory {
    Klant loggedInUser;

    public OrderHistory(Klant loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void ViewHistory() {
        System.out.println("--- Overzicht van mijn orders ---");
        System.out.println("");
        OrderRepository orderRepository = new OrderRepository();
        List<Order> orderList = orderRepository.findOrderByKlantId(loggedInUser.getKlant_id());
        for (Order order : orderList) {
            System.out.println(order);
        }
        MainMenu mainmenu = new MainMenu(loggedInUser);
        mainmenu.showMainMenu();
    }

}
