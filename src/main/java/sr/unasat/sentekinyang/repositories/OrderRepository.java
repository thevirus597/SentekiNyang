package sr.unasat.sentekinyang.repositories;

import sr.unasat.sentekinyang.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private Connection connection;

    public OrderRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost:3306/restaurant?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String USER = "root";
            String PASS = "root";
            connection = DriverManager.getConnection(URL, USER, PASS);
//            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> findAllMeals() {
        List<Order> orderList = new ArrayList<Order>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "SELECT orders.order_id AS ordernummer,\n" +
                    "restaurant.restaurant_naam AS restaurant, \n" +
                    "menu_naam AS menu,\n" +
                    "klant.naam,\n" +
                    "klant.telefoon,\n" +
                    "orders.levering_adres,\n" +
                    "orders.levering_prijs AS prijs\n" +
                    "FROM orders\n" +
                    "INNER JOIN klant ON orders.klant_id=klant.klant_id\n" +
                    "INNER JOIN menu ON orders.menu_id = menu.menu_id\n" +
                    "INNER JOIN restaurant ON menu.restaurant_id=restaurant.restaurant_id";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                orderList.add(
                        new Order(
                                rs.getInt("ordernummer"),
                                rs.getString("restaurant"),
                                rs.getString("menu"),
                                rs.getString("naam"),
                                rs.getString("telefoon"),
                                rs.getString("levering_adres"),
                                rs.getInt("prijs"))
                );
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return orderList;
    }


    public List<Order> findOrderByKlantId(int klant_id) {
        List<Order> orderList = new ArrayList<Order>();
        PreparedStatement stmt = null;
        String sql = "SELECT orders.order_id AS ordernummer,\n" +
                "restaurant.restaurant_naam AS restaurant, \n" +
                "menu_naam AS menu,\n" +
                "klant.naam,\n" +
                "klant.telefoon,\n" +
                "orders.levering_adres,\n" +
                "orders.levering_prijs AS prijs\n" +
                "FROM orders\n" +
                "INNER JOIN klant ON orders.klant_id=klant.klant_id\n" +
                "INNER JOIN menu ON orders.menu_id = menu.menu_id\n" +
                "INNER JOIN restaurant ON menu.restaurant_id=restaurant.restaurant_id WHERE orders.klant_id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, klant_id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst()) {
                System.out.println("error");
            } else {
                while (rs.next()) {
                    orderList.add(
                            new Order(
                                    rs.getInt("ordernummer"),
                                    rs.getString("restaurant"),
                                    rs.getString("menu"),
                                    rs.getString("naam"),
                                    rs.getString("telefoon"),
                                    rs.getString("levering_adres"),
                                    rs.getInt("prijs"))
                    );
                }
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return orderList;
    }

    public Order findOrderByOrderId(int order_id) {
        Order order = null;
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM orders WHERE order_id = ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order_id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                rs.next();
                order = new Order(
                        rs.getInt("order_id"),
                        rs.getInt("klant_id"),
                        rs.getInt("menu_id"),
                        rs.getString("levering_adres"),
                        rs.getInt("levering_prijs"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (connection != null) {
                    stmt.close();
                }
            } catch (SQLException e) {

            }
        }
        return order;
    }

    public void insertNewOrder(int klant_id, int menu_id, String levering_adres) {
        MenuRepository menuRepository = new MenuRepository();
        PreparedStatement stmt = null;
        try {
            String sql = "insert into orders (klant_id,menu_id,levering_adres,levering_prijs) values(?,?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, klant_id);
            stmt.setInt(2, menu_id);
            stmt.setString(3, levering_adres);
            stmt.setInt(4, menuRepository.getSingleMenuByMenuId(menu_id).getPrijs());

            stmt.executeUpdate();
            System.out.println("Order succesvol geplaatst");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {

        }
    }

    public int updateOrder(Order order) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update orders set menu_id=?, levering_adres=?, levering_prijs=? where order_id=?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order.getMenu_id());
            stmt.setString(2, order.getLevering_adres());
            stmt.setInt(3, order.getLevering_prijs());
            stmt.setInt(4, order.getOrder_id());

            result = stmt.executeUpdate();
            System.out.println("Order " + order.getOrder_id() + " succesvol geupdate");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    public int deleteOrder(int menu_id) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "delete from orders where order_id=?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, menu_id);

            result = stmt.executeUpdate();
            System.out.println("Order verwijdert");

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }
}

