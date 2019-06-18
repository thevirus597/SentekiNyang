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
            String sql = "select * from orders";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int klant_id = rs.getInt("klant_id");
                int menu_id = rs.getInt("menu_id");
                String levering_adres = rs.getString("levering_adres");
                int levering_prijs = rs.getInt("levering_prijs");
                orderList.add(new Order(order_id, klant_id, menu_id, levering_adres, levering_prijs));
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
        String sql = "SELECT * FROM orders WHERE klant_id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, klant_id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst()) {
                System.out.println("No user with given info!");
            } else {
                while (rs.next()) {
                    orderList.add(
                            new Order(rs.getInt("order_id"),
                                    rs.getInt("klant_id"),
                                    rs.getInt("menu_id"),
                                    rs.getString("levering_adres"),
                                    rs.getInt("levering_prijs"))
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

    public int insertNewMeal(Order order) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into order (klant.klant_id,menu.menu_id,levering_adres,levering_prijs) values(?,?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order.getKlant_id());
            stmt.setInt(2, order.getMenu_id());
            stmt.setString(3, order.getLevering_adres());
            stmt.setInt(4, order.getLevering_prijs());

            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int updateMeal(Order order) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update orders set menu_id=? where order_id=?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order.getMenu_id());
            stmt.setInt(1, order.getMenu_id());


            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int deleteMeal(Order order) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "delete from orders where order_id=?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order.getMenu_id());

            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }
}

