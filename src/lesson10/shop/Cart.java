package lesson10.shop;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Good> goods = new ArrayList<>();

    public  void addGood(Good good){
        goods.add(good);
    }

    public void removeFromCart(Good good){
        goods.remove(good);
    }

    public double getSumm(){
        double summ;

        for (Good good: goods){
            summ = + good.getPrice();
        }

            return summ;
    }


}
