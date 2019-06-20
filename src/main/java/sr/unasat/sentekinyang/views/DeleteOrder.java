package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.entities.Order;
import sr.unasat.sentekinyang.repositories.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class DeleteOrder {
    private Klant loggedInUser;
    char resume;

    public DeleteOrder(Klant loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void deleteOrderView() {
        Scanner input = new Scanner(System.in);
        int order_id;

        OrderRepository orderRepository = new OrderRepository();
        List<Order> orderList = orderRepository.findAllMeals();
        for (Order order : orderList) {
            System.out.println(order);
        }

        System.out.println("Vul de order_id die uw wilt verwijderen in: ");
        order_id = input.nextInt();
        orderRepository.deleteOrder(order_id);
        System.out.println("Order " + order_id + " is verwijdert");


        System.out.println("Wilt u verder gaan? (Y/N) ");
        resume = input.next().charAt(0);

        if (resume == 'y' || resume == 'Y') {
            MainMenu mainmenu = new MainMenu(loggedInUser);
            mainmenu.showMainMenu();
        }
    }
}
