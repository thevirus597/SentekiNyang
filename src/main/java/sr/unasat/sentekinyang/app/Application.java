package sr.unasat.sentekinyang.app;
import java.util.*;
import sr.unasat.sentekinyang.views.MainMenu;

import java.util.List;

public class Application {
    public static void main(String[] args) {
//        OrderRepository orderRepository = new OrderRepository();
//        List<Order> orderList = orderRepository.findAllRecords();
//        for (Order order : orderList) {
//            System.out.println(order);
//        }
//    }
        MainMenu mainmenu = new MainMenu(); //MainMenu class declaratie
        Scanner input = new Scanner(System.in);

        String username;
        String password;

        System.out.println("---- LOG IN ----:");
        System.out.println("");
        System.out.println("Username: ");
        username = input.next();

        System.out.println("Password: ");
        password = input.next();

        //user check = new users(username, password);
        if(username.equals(username) && password.equals(password))
            mainmenu.showMainMenu(); // toont Menu in de views package

    }
}


