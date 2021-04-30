package service;

import model.App.App;
import model.Order.Order;
import model.Restaurant.Dish;
import model.Restaurant.Restaurant;
import model.User.Customer;
import model.User.Driver;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class customerService {

    private LoginService returnLogin = LoginService.getInstance();

    private static customerService instance = null;

    private customerService(){}

    public static customerService getInstance(){
        if (instance == null) {
            instance = new customerService();
        }
        return instance;
    }

    Scanner fetch = new Scanner(System.in);

    public void Main(App app, Customer user){
        System.out.println("You are logged in as a customer");
        while(true){
            System.out.println("1. Create order");
            System.out.println("2. Logout");
            System.out.println("3. Delete account");
            System.out.println("0. Exit");
            int option = fetch.nextInt();

            ArrayList<Restaurant> restaurants = app.getRestaurants();

            switch(option){
                case 1:
                    System.out.println("Choose a restaurant");
                    ArrayList<Restaurant> restaurantsList = new ArrayList<>(restaurants);

                    for (Restaurant restaurant : restaurantsList) {
                        System.out.println(restaurantsList.indexOf(restaurant) + " - " + restaurant.getName());
                    }

                    int selected = fetch.nextInt();
                    Restaurant selectedRestaurant = restaurantsList.get(selected);
                    ArrayList<Dish> restaurantItems = selectedRestaurant.getMenu();

                    for (Dish item : restaurantItems) {
                        System.out.println(restaurantItems.indexOf(item) + " - " + item.getName() + " costs " + item.getPrice());
                    }

                    ArrayList<Dish> itemsToOrder = new ArrayList<>();
                    System.out.println("Select what items you want to order by choosing their respective number \n For example : 1,3,5 \n");
                    String response = fetch.next();
                    String[] choices = response.split(",");
                    for (String c : choices) {
                        int productNumber = parseInt(c);
                        itemsToOrder.add(restaurantItems.get(productNumber));
                    }

                    Driver orderDriver = new Driver("Denis", "Dobrica", "dublednr1@gmail.com", "pwtest123!", "0722156430", "Honolulu");

                    Order order = new Order(user, orderDriver);
//                    to add items
                    app.getOrders().add(order);
                    

                    break;
                case 2:
                    returnLogin.Main(app);
                case 3:
                    app.getCustomers().remove(user);
                    System.out.println("Acc deleted");
                    returnLogin.Main(app);
                default:
                    System.out.println("Choose a valid option");
            }
        }
    }
}
