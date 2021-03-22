package service;

import model.App.App;
import model.User.Customer;
import model.User.Driver;
import model.User.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class LoginService {

    private static LoginService instance = null;

    private LoginService(){}

    public static LoginService getInstance(){
        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }

    Scanner fetch = new Scanner(System.in);
    int select;

    public void Main(App app){

        for(;;){
            System.out.println("Select an option");
            System.out.println("1. Login");
            System.out.println("2. Sign up as customer");
            System.out.println("3. Sign up as driver");
            System.out.println("0. Exit");
            select = fetch.nextInt();

            switch(select){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    for(;;){
                        System.out.println("Email");
                        String email = fetch.next();
                        System.out.println("Password");
                        String password = fetch.next();
                        User user = this.findUser(email, password, app.getUsers());
                        if (user == null){
                            System.out.println("Try again.");
                            break;
                        }
                        else if (user instanceof Customer){
//                        CustomerService customerService = new CustomerService();
//                        customerService.Main(app,(Customer) user);
                            break;
                        }
                        else if (user instanceof Driver){
                            //CustomerService customerService = new CustomerService();
//                        customerService.Main(app,(Customer) user);
                            break;
                        }
                    }
                    break;
                case 2:
                    signUpCustomer(app);
                    break;
                case 3:
                    signUpDriver(app);
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        }
    }

    private User findUser(String email, String password, ArrayList<User> users){
        for (User user : users){
            if (user.getPassword().equals(password) && user.getEmail().equals(email)){ //
                return user;
            }
        }
        return null;
    }

    private void signUpCustomer(App app){
        System.out.println("First name:");
        String firstname = fetch.next();
        System.out.println("Last name");
        String lastname = fetch.next();
        System.out.println("Email:");
        String email = fetch.next();
        System.out.println("Password ");
        String password = fetch.next();
        System.out.println("Phone:");
        String phone = fetch.next();
        System.out.println("Address");
        String address = fetch.next();

        Customer customer = new Customer(firstname, lastname, email, password, phone, address);
        app.getCustomers().add(customer);
    }

    private void signUpDriver(App app){
        System.out.println("First name:");
        String firstname = fetch.next();
        System.out.println("Last name");
        String lastname = fetch.next();
        System.out.println("Email:");
        String email = fetch.next();
        System.out.println("Password ");
        String password = fetch.next();
        System.out.println("Phone:");
        String phone = fetch.next();
        System.out.println("Address");
        String address = fetch.next();

        Driver driver = new Driver(firstname, lastname, email, password, phone, address);
        app.getDriver().add(driver);
    }

}
