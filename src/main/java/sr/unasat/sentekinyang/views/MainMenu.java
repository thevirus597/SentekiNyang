package sr.unasat.sentekinyang.views;
import java.util.Scanner;
public class MainMenu {
    public void showMainMenu(){


        System.out.println("--- WELKOM BIJ SENTEKINYANG ---");
        System.out.println("");
        Scanner in = new Scanner(System.in);
        // Display the menu
        System.out.println("Kies een van de onderstaande opties:");
        System.out.println("");
        System.out.println("1\t Order plaatsen");
        System.out.println("2\t Dagmenu bekijken");
        System.out.println("3\t Overzicht orders");
        System.out.println("4\t Afsluiten");


        //Get user's choice
        int choice = in.nextInt();

        //Display the title of the chosen module
        switch (choice) {
            case 1:
                System.out.println("Welcome to the order screen");
                PlaceOrder placeOrder = new PlaceOrder();
                placeOrder.ShowOrderScreen();
                break;
            case 2:
                System.out.println("Menu van de dag");
                MenuItems menuitems = new MenuItems();
                menuitems.ShowFoodItems();
                break;
            case 3:
                System.out.println("Overzicht van geplaatste orders");
                OrderHistory orderhistory = new OrderHistory();
                orderhistory.ViewHistory();
                break;
            default:
                System.out.println("Verkeerde keuze, kies aub een der bovenstaande opties");
        }//end of switch
    }
}