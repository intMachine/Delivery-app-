package model.User;

import model.Order.Order;

import java.util.ArrayList;

public class User {

    protected static int global_id = 0;
    protected int id;
    protected String username;
    protected String firstname;
    protected String lastname;
    protected String email;
    protected String password;
    protected String phone;
    protected String address;
    protected ArrayList<Order> orders;

    public User(String firstname, String lastname, String email, String password, String phone, String address)
    {
        global_id += 1;
        this.id = global_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.orders = new ArrayList<Order>();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }
}
