package sr.unasat.sentekinyang.views;
import java.util.Scanner;
import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.entities.Order;
import sr.unasat.sentekinyang.repositories.OrderRepository;


import java.util.List;

public class OrderHistory {
    Klant loggedInUser;
    char resume;

    public OrderHistory(Klant loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void ViewHistory() {
        Scanner input = new Scanner(System.in);

        System.out.println("--- Overzicht van mijn orders ---");
        System.out.println("");
        OrderRepository orderRepository = new OrderRepository();
        List<Order> orderList = orderRepository.findOrderByKlantId(loggedInUser.getKlant_id());
        for (Order order : orderList) {
            System.out.println(order);
        }

        System.out.println("Wilt u verder gaan? (Y/N) ");
        resume = input.next().charAt(0);

        if (resume == 'y' || resume == 'Y') {
            MainMenu mainmenu = new MainMenu(loggedInUser);
            mainmenu.showMainMenu();
        }
    }


}
