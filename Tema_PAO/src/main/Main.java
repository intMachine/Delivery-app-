package main;

import model.App.App;
import model.User.User;
import service.csvReader;
import service.csvWriter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        User user = new User("Denis", "Dobrica", "denisdobrica@gmail.com", "parolatest123", "0722156430", "Randunelelor");

        csvWriter csvW = csvWriter.getInstance();
        csvW.write(user);
    }
}