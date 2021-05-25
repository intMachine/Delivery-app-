package repository;

import config.DatabaseConnection;
import model.User.Customer;
import model.User.Driver;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    private static DriverRepository instance = null;
    private DriverRepository(){}

    public static DriverRepository getInstance() {
        if(instance == null){
            instance = new DriverRepository();
        }
        return instance;
    }

    public void addDriver(Driver driver){

        String sql = "insert into drivers ( username, firstname, lastname, email, password, phone, address, age ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, driver.getUsername());
            statement.setString(2, driver.getFirstname());
            statement.setString(3, driver.getLastname());
            statement.setString(4, driver.getEmail());
            statement.setString(5, driver.getPassword());
            statement.setString(6, driver.getPhone());
            statement.setString(7, driver.getAddress());
            statement.setString(9, String.valueOf(driver.getAge()));
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Driver getDriver(int userId){
        String sql = "select * from drivers where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setString(1, String.valueOf(userId));
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String firstname = result.getString(2);
                String lastname = result.getString(3);
                String username = result.getString(4);
                String email = result.getString(5);
                String password = result.getString(6);
                String phone = result.getString(7);
                String address = result.getString(8);
                int age = Integer.parseInt(result.getString(9));
                Driver driver = new Driver(firstname, lastname ,email, password, phone, address, age);
                return driver;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Driver> getDriver(){
        List<Driver> drivers = new ArrayList<>();
        String sql = "select * from drivers";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String id = result.getString(1);
                String firstname = result.getString(2);
                String lastname = result.getString(3);
                String username = result.getString(4);
                String email = result.getString(5);
                String password = result.getString(6);
                String phone = result.getString(7);
                String address = result.getString(8);
                int age = Integer.parseInt(result.getString(9));
                drivers.add(new Driver(firstname, lastname ,email, password, phone, address, age));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  drivers;
    }

    public void updateDriver(int id, Driver driver){
        String sql = "update drivers " +
                "set firstname = ?," +
                "lastname = ?," +
                "username = ?," +
                "email = ?," +
                "password = ?," +
                "phone = ?," +
                "address = ?" +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setInt(8 , id);
            statement.setString(1, driver.getFirstname());
            statement.setString(2, driver.getLastname());
            statement.setString(3, driver.getLastname());
            statement.setString(4, driver.getEmail());
            statement.setString(5, driver.getPassword());
            statement.setString(6, driver.getPhone());
            statement.setString(7, driver.getAddress());
            statement.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteDriver(int id){
        String sql = "delete from drivers " +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, String.valueOf(id));
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}