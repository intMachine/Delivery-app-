package service;

public class driverService {

    private static driverService instance = null;

    private driverService(){}

    public static driverService getInstance(){
        if (instance == null) {
            instance = new driverService();
        }
        return instance;
    }
}
