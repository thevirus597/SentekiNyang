package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.entities.Menu;
import sr.unasat.sentekinyang.entities.Restaurant;
import sr.unasat.sentekinyang.repositories.MenuRepository;
import sr.unasat.sentekinyang.repositories.RestaurantRepository;

import java.util.List;
import java.util.Scanner;

public class MenuItems {
    Klant loggedInUser;
    char resume;

    public MenuItems(Klant loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    Scanner input = new Scanner(System.in);

    public void ShowFoodItems() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        MenuRepository menuRepository = new MenuRepository();
        int restaurant_id;
        char resume;

        System.out.println("--- Kies een restaurant om de menu te zien ---");
        System.out.println("");
        List<Restaurant> restaurantList = restaurantRepository.findAllRestaurants();
        for (Restaurant restaurant : restaurantList) {
            System.out.println(restaurant);
        }
        System.out.println("Restaurant_id: ");
        restaurant_id = input.nextInt();
        List<Menu> menuList = menuRepository.findMenuByRestaurantId(restaurant_id);
//        List<Menu> menuList = menuRepository.findAllMenus();
        for (Menu menu : menuList) {
            System.out.println(menu);
        }

        System.out.println("Wilt u verder gaan? (Y/N) ");
        resume = input.next().charAt(0);

        if (resume == 'y' || resume == 'Y') {
            MainMenu mainmenu = new MainMenu(loggedInUser);
            mainmenu.showMainMenu();
        }
    }
}

