package sr.unasat.sentekinyang.repositories;

import sr.unasat.sentekinyang.entities.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private Connection connection;

    public RestaurantRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost:3306/restaurant?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String USER = "root";
            String PASS = "";
            connection = DriverManager.getConnection(URL, USER, PASS);
//            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> findAllRestaurants() {
        List<Restaurant> restaurantList = new ArrayList<Restaurant>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "SELECT * FROM restaurant";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                restaurantList.add(
                        new Restaurant(
                                rs.getInt("restaurant_id"),
                                rs.getString("restaurant_naam"),
                                rs.getString("restaurant_adres"),
                                rs.getString("restaurant_telefoon"))
                );
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return restaurantList;
    }
}
