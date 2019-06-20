package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.entities.Menu;
import sr.unasat.sentekinyang.entities.Order;
import sr.unasat.sentekinyang.repositories.MenuRepository;
import sr.unasat.sentekinyang.repositories.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class UpdateOrder {
    private Klant loggedInUser;
    char resume;

    public UpdateOrder(Klant loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void updateOrderView() {
        Scanner input = new Scanner(System.in);
        int order_id;
        OrderRepository orderRepository = new OrderRepository();
        MenuRepository menuRepository = new MenuRepository();
        List<Order> orderList = orderRepository.findAllMeals();
        for (Order order : orderList) {
            System.out.println(order);
        }
        System.out.println("Vul de order id van de order die u wilt aanpassen in: ");
        order_id = input.nextInt();
        Order orderToUpdate = orderRepository.findOrderByOrderId(order_id);
        List<Menu> menuList = menuRepository.findAllMenus();
        for (Menu menu : menuList) {
            System.out.println(menu);
        }
        System.out.println("Vul de menu_id in:");
        orderToUpdate.setMenu_id(input.nextInt());
        System.out.println("Vul de levering adres in:");
        orderToUpdate.setLevering_adres(input.next());
        orderToUpdate.setLevering_prijs(menuRepository.getSingleMenuByMenuId(orderToUpdate.getMenu_id()).getPrijs());
        orderRepository.updateOrder(orderToUpdate);


        System.out.println("Wilt u verder gaan? (Y/N) ");
        resume = input.next().charAt(0);

        if (resume == 'y' || resume == 'Y') {
            MainMenu mainmenu = new MainMenu(loggedInUser);
            mainmenu.showMainMenu();
        }
    }
}
