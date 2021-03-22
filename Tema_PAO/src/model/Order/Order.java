package model.Order;

import model.Restaurant.Dish;
import model.User.Driver;
import model.User.User;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private static int global_id = 0;
    private int id;
    private User user;
    private Driver driver;
    private Map<Dish, Integer> qty;

    public Order(User user, Driver driver){
        global_id += 1;
        this.id = global_id;
        this.user = user;
        this.driver = driver;
        qty = new HashMap<Dish, Integer>();
    }

    public float getPrice(){
        float price = 0;
        for (Map.Entry<Dish, Integer> me : qty.entrySet()) {
            price += me.getKey().getPrice() * me.getValue();
        }
        return price;
    }

    public void addItem(Dish item, int quantity){
        qty.put(item, quantity);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", driver=" + driver +
                '}';
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Map<Dish, Integer> getQty() {
        return qty;
    }

}
