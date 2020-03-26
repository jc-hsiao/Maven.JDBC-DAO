package daos;

import models.Attorney;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AttorneyDao implements Dao<Attorney>{


    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private Attorney extractDataFromResultSet(ResultSet rs) throws SQLException {
        Attorney a = new Attorney();
        a.setId( rs.getInt("id") );
        a.setFirstName( rs.getString("firstName") );
        a.setLastName( rs.getString("lastName") );
        a.setAge( rs.getInt("age") );
        a.setOccupation( rs.getString("occupation"));
        a.setEyeColor( rs.getString("eyeColor") );
        a.setHairColor( rs.getString("hairColor"));
        a.setThemeColor( rs.getString("themeColor"));
        a.setOffice( rs.getString("office") );
        return a;
    }

    public Attorney findById(int id) {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Attorney WHERE id=" + id);
            if(rs.next()) {
                return extractDataFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Attorney> findAll() {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Attorney");
            List<Attorney> arr = new ArrayList<Attorney>();
            while(rs.next()) {
                Attorney a = extractDataFromResultSet(rs);
                arr.add(a);
            }
            return arr;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Attorney update(Attorney dto) {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();
        try {
            PreparedStatement rs = connection.prepareStatement("UPDATE Attorney SET firstName=?, lastName=?, age=?, occupation=? ,eyeColor=?, hairColor=?, themeColor=?, office=?  WHERE id=?");

            rs.setString(1, dto.getFirstName());
            rs.setString(2, dto.getLastName());
            rs.setInt(3, dto.getAge());
            rs.setString(4, dto.getOccupation());
            rs.setString(5, dto.getEyeColor());
            rs.setString(6, dto.getHairColor());
            rs.setString(7, dto.getThemeColor());
            rs.setString(8, dto.getOffice());
            rs.setInt(9, dto.getId());
            int i = rs.executeUpdate();

            if(i == 1) {
                LOGGER.info("Update successful");
                return dto;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Attorney create(Attorney dto) {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();
        try {
            PreparedStatement rs = connection.prepareStatement("INSERT INTO Attorney (`FirstName`,`LastName`,`age`,`Occupation`,`EyeColor`,`HairColor`,`ThemeColor`,`Office`) values(?,?,?,?,?,?,?,?)");

            rs.setString(1, dto.getFirstName());
            rs.setString(2, dto.getLastName());
            rs.setInt(3, dto.getAge());
            rs.setString(4, dto.getOccupation());
            rs.setString(5, dto.getEyeColor());
            rs.setString(6, dto.getHairColor());
            rs.setString(7, dto.getThemeColor());
            rs.setString(8, dto.getOffice());
            int i = rs.executeUpdate();

            if(i == 1) {
                LOGGER.info("Insert successful");
                return dto;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM Attorney WHERE id=" + id);
            LOGGER.info("Delete successful");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
