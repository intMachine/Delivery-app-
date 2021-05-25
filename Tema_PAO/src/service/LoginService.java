package service;

import model.User.*;
import model.App.App;
//import model.User.Customer;
//import model.User.Driver;
//import model.User.User;

import java.util.ArrayList;
import java.util.Scanner;


public class loginService {

    private static loginService instance = null;
    private final auditService audit = auditService.getInstance();

    private loginService(){}

    public static loginService getInstance(){
        if (instance == null) {
            instance = new loginService();
        }
        return instance;
    }

    protected static Scanner fetch = new Scanner(System.in);
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
//                        System.out.println(email);
//                        System.out.println(password);
                        User user = this.findUser(email, password, app.getUsers());
                        audit.write("Login - "+ user.getUsername());
                        if (user == null){
                            System.out.println("Try again.");
                            break;
                        }
                        else if (user instanceof Customer){
//                            System.out.println("A");
                        customerService customerService = service.customerService.getInstance();
                        customerService.Main(app, (Customer) user);

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
//            else {
//                System.out.println("Acest cont nu există în baza de date");
//            }
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
        app.getUsers().add(customer);
//        app.getCustomers().forEach(System.out::println);
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
        System.out.println("Age");
        int age = Integer.parseInt(fetch.next());

        Driver driver = new Driver(firstname, lastname, email, password, phone, address, age);
        app.getDriver().add(driver);
        app.getUsers().add(driver);
    }

}
