package model.User;

public class Driver extends User {

    private int incomeMultiplier;
    private int age;

    public Driver(String firstname, String lastname, String email, String password, String phone, String address, int age)
    {
        super(firstname, lastname, email, password, phone, address);
        this.age = age;
        this.incomeMultiplier = incomeMultiplier;
    }

    @Override
    public String   toString() {
        return "Driver{" +
                "incomeMultiplier=" + incomeMultiplier +
                ", age=" + age +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getIncomeMultiplier() {
        return incomeMultiplier;
    }

    public void setIncomeMultiplier(int incomeMultiplier) {
        if ( age > 60){
            this.incomeMultiplier = 2;
        }
        else this.incomeMultiplier = 1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int income) {
        this.age = income;
    }
}
