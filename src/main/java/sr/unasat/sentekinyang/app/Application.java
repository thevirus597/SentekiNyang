package sr.unasat.sentekinyang.app;

import java.util.*;

import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.repositories.KlantRepository;
import sr.unasat.sentekinyang.repositories.OrderRepository;
import sr.unasat.sentekinyang.views.MainMenu;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.findAllMeals();
//        Scanner input = new Scanner(System.in);
//
//        String username;
//        String password;
//
//        System.out.println("---- LOG IN ----:");
//        System.out.println("");
//        System.out.println("Username: ");
//        username = input.next();
//
//        System.out.println("Password: ");
//        password = input.next();
//
//        KlantRepository klantRepository = new KlantRepository();
//        boolean isLoggedIn = klantRepository.login(username, password);
//        if (isLoggedIn) {
//            Klant loggedInUser = klantRepository.findUserByUsername(username);
//            MainMenu mainmenu = new MainMenu(loggedInUser);
//            loggedInUser.setLoggedIn(true);
//            mainmenu.showMainMenu();
//        } else {
//            System.out.println("Credentials Incorrect!");
//        }
    }
}


