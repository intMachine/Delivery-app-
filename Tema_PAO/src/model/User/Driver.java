package model.User;

public class Driver extends User {

    private int incomeMultiplier;
    private int income;

    public Driver(String firstname, String lastname, String email, String password, String phone, String address)
    {
        super(firstname, lastname, email, password, phone, address);
        this.income = income;
        this.incomeMultiplier = incomeMultiplier;
    }

    @Override
    public String   toString() {
        return "Driver{" +
                "incomeMultiplier=" + incomeMultiplier +
                ", income=" + income +
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
        this.incomeMultiplier = incomeMultiplier;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
