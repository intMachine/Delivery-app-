package main;

import model.App.App;
import model.Restaurant.Ingredient;
import model.Restaurant.Restaurant;
import model.User.Customer;
import model.User.User;
import repository.UserRepository;
import model.Restaurant.Dish;
import service.*;
import java.util.ArrayList;

public class Main {

    private static UserRepository userRepository = UserRepository.getInstance();


    public static void main(String[] args) {

        App app = new App();
        loginService ls = loginService.getInstance();


        Customer customer = new Customer("Denis", "Dobricuts", "denisdobrica@gmail.com", "parolatest123", "0722156430", "Randunelelor");
//        UserRepository.addUser(customer);
        ArrayList<Customer> usersapp = new ArrayList<Customer>();
        usersapp.add(customer);
        app.setCustomers(usersapp);

        User customer2 = new User("Eu", "Eux", "denisdobrica@gmail.com", "parolatest123", "0722156430", "Randunelelor");
        ArrayList<User> usersapp2 = new ArrayList<User>();
        usersapp2.add(customer2);
        app.setUsers(usersapp2);
//        Test();
        Ingredient sare = new Ingredient("Sare", true);
        ArrayList<Ingredient> ingredients1 = new ArrayList<Ingredient>();
        ingredients1.add(sare);
        Dish dish1 = new Dish("dish1", ingredients1, 240, "ia de gusta");
        Dish dish2 = new Dish("dish1", ingredients1, 240, "ia de gusta");

        ArrayList<Dish> menu = new ArrayList<>();
        menu.add(dish1);
        menu.add(dish2);
        Restaurant restaurant = new Restaurant("La Tase", menu, 3);
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant);
        app.setRestaurants(restaurants);
        ls.Main(app);




//        System.out.println(dish1);

//        csvWriter csvW = csvWriter.getInstance();
//        csvW.write(user);
    }

    private static void Test() {
        Customer customer = new Customer("Domnoo", "Consul", "denisdobrica@gmail.com", "parolatest123", "0722156430", "aici");
//        userRepository.addUser(customer);
        System.out.println(userRepository.getUser(2));
//        userRepository.updateUser(2, customer);
//        app.getCustomers().forEach(System.out::println);
    }
}