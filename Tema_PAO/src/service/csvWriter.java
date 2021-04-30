package service;

import model.Restaurant.Dish;
import model.Restaurant.Ingredient;
import model.User.Customer;
import model.User.Driver;
import model.User.User;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;


public class csvWriter {

    private static csvWriter instance = null;
    Map<String, Path> paths;

    public static csvWriter getInstance() {
        if (instance == null) {
            instance = new csvWriter();
        }
        return instance;
    }

    private csvWriter() {
        paths = new HashMap<>();
        paths.put("User", Path.of("files/users.csv"));
        paths.put("Driver", Path.of("files/drivers.csv"));
        paths.put("Customer", Path.of("files/customers.csv"));
        //paths.put("Restaurant", Path.of("files/restaurants.csv"));
        paths.put("Dishes", Path.of("files/dishes.csv"));

        for (Path path : paths.values()) {
            if (!Files.exists(path)) {
                try {
                    Files.createFile(path);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void write(User user) {
        try {
            System.out.println("Writing user");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(paths.get("User"), StandardOpenOption.APPEND);
            String output = user.getId() + "," +
                    user.getLastname() + "," +
                    user.getFirstname() + "," +
                    user.getEmail() + "," +
                    user.getPassword() + "," +
                    user.getPhone() + "," +
                    user.getAddress() + "," ;
            bufferedWriter.write(output + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(Customer customer) {
        write((User) customer);
        try {
            System.out.println("Writing user");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(paths.get("Driver"), StandardOpenOption.APPEND);
            String output = customer.getId() + ",";
            bufferedWriter.write(output + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(Driver driver) {
        write((User) driver);
        try {
            System.out.println("Writing user");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(paths.get("Driver"), StandardOpenOption.APPEND);
            String output = driver.getId() + "," +
                    driver.getIncome() + "," +
                    driver.getIncomeMultiplier();
            bufferedWriter.write(output + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(Dish dish) {
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(paths.get("Dishes"), StandardOpenOption.APPEND);
            String ingredients = "";
            if(dish.getIngredients().size()>0){
                for (Ingredient ingredient : dish.getIngredients()) {
                    ingredients += ingredient + ";";
                }
                ingredients = ingredients.substring(0, ingredients.length() - 1);
            }

            String output = dish.getId() + "," +
                    dish.getDescription() + "," +
                    dish.getPrice() + "," +
                    ingredients;

            bufferedWriter.write(output + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}
