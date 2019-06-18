package sr.unasat.sentekinyang.repositories;

import sr.unasat.sentekinyang.entities.Klant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KlantRepository {
    private Connection connection;
    public KlantRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost:3306/restaurant";
            String USER = "root";
            String PASS = "";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

                klantList.add(new Klant(klant_id, naam, adres, telefoon));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return klantList;
    }
}
