package service;

import model.Restaurant.Dish;
import model.Restaurant.Ingredient;
import model.User.Customer;
import model.User.Driver;
import model.User.User;

import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class csvReader {

    private static csvReader instance = null;
    private Map<String, Path> paths;

    public static csvReader getInstance() {
        if (instance == null) {
            instance = new csvReader();
        }
        return instance;
    }

    private csvReader() {
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

    public ArrayList<Customer> readCustomers() throws IOException {
        ArrayList<Customer> customers = new ArrayList<>();
        BufferedReader bufferedReader = Files.newBufferedReader(paths.get(0));
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] cstmrs = line.split(",");
            String firstname = cstmrs[0];
            String lastname = cstmrs[1];
            String email = cstmrs[2];
            String phone = cstmrs[3];
            String password = cstmrs[4];
            String address = cstmrs[5];
            customers.add(new Customer(firstname, lastname, email, password, phone, address));
            line = bufferedReader.readLine();
        }
        return customers;
    }



}
