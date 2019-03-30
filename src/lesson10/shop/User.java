package lesson10.shop;

import java.util.Objects;

public class User {
    private String login;
    private String pwd;
    private double balance;
    private Cart cart;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void regCart(Cart cart){
        this.cart = cart;
    }

    public User(String login, String pwd, double balance) {
        this.login = login;
        this.pwd = pwd;
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Double.compare(user.getBalance(), getBalance()) == 0 &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPwd(), user.getPwd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPwd(), getBalance());
    }
}
