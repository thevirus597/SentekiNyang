package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Klant;

import java.util.Scanner;

public class MainMenu {
    private Klant loggedInUser;

    public MainMenu(Klant loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void showMainMenu() {

        System.out.println("--- WELKOM BIJ SENTEKINYANG ---");
        System.out.println("");
        Scanner in = new Scanner(System.in);
        // Display the menu
        System.out.println("Kies een van de onderstaande opties:");
        System.out.println("");
        System.out.println("1\t Order plaatsen");
        System.out.println("2\t Dagmenu bekijken");
        System.out.println("3\t Overzicht orders");
        System.out.println("4\t Overzicht klanten");
        System.out.println("5\t Mijn gegevens");
        System.out.println("6\t Afsluiten");


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
                System.out.println("Overzicht van mijn geplaatste orders");
                OrderHistory orderhistory = new OrderHistory(loggedInUser);
                orderhistory.ViewHistory();
                break;
            case 4:
                System.out.println("Overzicht van alle klanten");
                Klanten klanten = new Klanten();
                klanten.showKlantenOverview();
                break;
            case 5:
                System.out.println("Mijn gegevens");
                UserInfo userInfo = new UserInfo(loggedInUser);
                userInfo.showUserInfo();
                break;
            default:
                System.out.println("Verkeerde keuze, kies aub een der bovenstaande opties");
        }//end of switch
    }
}