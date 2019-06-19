package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.entities.Menu;
import sr.unasat.sentekinyang.repositories.MenuRepository;
import sr.unasat.sentekinyang.repositories.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class PlaceOrder {
    private Klant loggedInUser;
char resume;
    public PlaceOrder(Klant loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void ShowOrderScreen() {
        int menu_id;
        String levering_adres;

        Scanner input = new Scanner(System.in);
        System.out.println("--- Plaats een bestelling ---");
        System.out.println("");
        MenuRepository menuRepository = new MenuRepository();
        OrderRepository orderRepository = new OrderRepository();
        List<Menu> menuList = menuRepository.findAllMenus();
        for (Menu menu : menuList) {
            System.out.println(menu);
        }
        System.out.println("Vul de menu id in: ");
        menu_id = input.nextInt();

        System.out.println("Vul de levering adres in: ");
        levering_adres = input.next();
        orderRepository.insertNewOrder(loggedInUser.getKlant_id(), menu_id, levering_adres);


        System.out.println("Wilt u verder gaan? (Y/N) ");
        resume = input.next().charAt(0);

        if (resume == 'y' || resume == 'Y') {
            MainMenu mainmenu = new MainMenu(loggedInUser);
            mainmenu.showMainMenu();
        }


    }
}
