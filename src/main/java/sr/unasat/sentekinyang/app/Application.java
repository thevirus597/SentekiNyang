package sr.unasat.sentekinyang.app;

import sr.unasat.sentekinyang.entities.Order;
import sr.unasat.sentekinyang.repositories.OrderRepository;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();
        List<Order> orderList = orderRepository.findAllRecords();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }
}
