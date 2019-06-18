package sr.unasat.sentekinyang.repositories;
import sr.unasat.sentekinyang.entities.Klant;
import sr.unasat.sentekinyang.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private Connection connection;

    public OrderRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost:3306/restaurant";
            String USER = "root";
            String PASS = "root";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> findAllRecords() {
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

    public List<Klant> findAllKlanten() {
        List<Klant> klantList = new ArrayList<Klant>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from klant";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                int klant_id = rs.getInt("klant_id");
                String naam = rs.getString("naam");
                String adres = rs.getString("adres");
                String telefoon = rs.getString("telefoon");

                klantList.add(new Klant(klant_id,naam,adres,telefoon));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return klantList;
    }
    public int insertOneRecord(Order order) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into order (naam) values(?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order.getKlant_id());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }
}
