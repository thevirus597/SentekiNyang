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

    public Klant findUserByUsername(String username){
        Klant klant = null;
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM klant WHERE username = ? LIMIT 1";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst() ) {
                System.out.println("No user with given info!");
            }else{
                rs.next();

                klant = new Klant(rs.getInt("klant_id"),
                        rs.getString("naam"),
                        rs.getString("adres"),
                        rs.getString("telefoon"));
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
            try {
                if(connection != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
        }
        return klant;
    }

    public boolean login(String username, String password) {
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM klant WHERE username= ? AND password = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst()) {
                return false;
            } else {
                rs.next();

            }
            rs.close();
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
        return true;
    }
}
