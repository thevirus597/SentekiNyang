package sr.unasat.sentekinyang.repositories;

import sr.unasat.sentekinyang.Helper.DatabaseConfig;
import sr.unasat.sentekinyang.entities.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private Connection connection;

    public RestaurantRepository() {
        DatabaseConfig databaseConfig = new DatabaseConfig();
        connection = databaseConfig.dbConnection();
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
