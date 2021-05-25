package model.App;

import model.Order.Order;
import model.Restaurant.Restaurant;
import model.User.Customer;
import model.User.Driver;
import model.User.User;

import java.util.ArrayList;

public class App {
    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    private ArrayList<User> users =  new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Driver> driver = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

        public ArrayList<Restaurant> getRestaurants() {
            return restaurants;
        }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Driver> getDriver() {
        return driver;
    }

    public void setDriver(ArrayList<Driver> driver) {
        this.driver = driver;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
