package smartwallet.model;

public class Account {
    private String name;
    private String username;
    private double balance;
    private String type; // BASIC / PREMIUM

    public Account(String name, String username, String type) {
        this.name = name;
        this.username = username;
        this.type = type;
        this.balance = 0.0;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return username + "|" + name + "|" + type + "|" + balance;
    }
}