package sr.unasat.sentekinyang.views;

import sr.unasat.sentekinyang.entities.Order;
import sr.unasat.sentekinyang.repositories.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class DeleteOrder {
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
        orderRepository.deleteMeal(order_id);
        System.out.println("Order " + order_id + " is verwijderd");
    }
}