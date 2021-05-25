package repository;

import config.DatabaseConnection;
import model.User.Customer;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static CustomerRepository instance = null;
    private CustomerRepository(){}

    public static CustomerRepository getInstance() {
        if(instance == null){
            instance = new CustomerRepository();
        }
        return instance;
    }

    public void addUser(Customer user){

        String sql = "insert into customers ( username, firstname, lastname, email, password, phone, address ) VALUES ( ?, ?, ?, ?, ?, ?, ? )";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFirstname());
            statement.setString(3, user.getLastname());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getAddress());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Customer getUser(int userId){
        String sql = "select * from customers where id = ?";
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
                Customer user = new Customer(firstname, lastname ,email, password, phone, address);
                return user;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Customer> getUsers(){
        List<Customer> users = new ArrayList<>();
        String sql = "select * from customers";
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
                users.add(new Customer(firstname, lastname ,email, password, phone, address));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  users;
    }

    public void updateUser(int id, Customer user){
        String sql = "update customers " +
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
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getLastname());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getAddress());
            statement.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteUser(int id){
        String sql = "delete from customers " +
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