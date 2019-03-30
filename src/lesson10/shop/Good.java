package lesson10.shop;

import java.util.Objects;

public class Good {
    private String title;
    private double price;

    public Good(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }



    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Good)) return false;
        Good good = (Good) o;
        return Double.compare(good.getPrice(), getPrice()) == 0 &&
                Objects.equals(getTitle(), good.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPrice());
    }

    @Override
    public String toString() {
        return "Good{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
