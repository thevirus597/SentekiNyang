package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Menu;
import sr.unasat.sentekinyang.repositories.MenuRepository;

import java.util.List;

public class MenuItems {
    public void ShowFoodItems() {
        System.out.println("--- Menu van de dag ---");
        System.out.println("");
        MenuRepository menuRepository = new MenuRepository();
        List<Menu> menuList = menuRepository.findAllMenus();
        for (Menu menu : menuList) {
            System.out.println(menu);
        }
    }
}

