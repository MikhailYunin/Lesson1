package lambda;


import java.util.concurrent.ConcurrentSkipListMap;

public class LambdaStrategy {
    public static void main(String[] args) {
        Order order = new Order(700);
        order.payOrder(PayActions.PAYPAL);
        order.payOrder(PayActions.MASTERCARD);

    }
}


class StrategyRegister<T> {
    private ConcurrentSkipListMap<PayActions, T> map = new ConcurrentSkipListMap<>();

    public void add(PayActions actionName, T action) {
        map.put(actionName, action);
    }

    public T get(PayActions actionName) {
        return this.map.get(actionName);
    }

    public void remove(String actionName){
        this.map.remove(actionName);
    }
}

class Order {
    private StrategyRegister<Runnable> payActions = new StrategyRegister<>();

    private int sum;

    public Order(int sum) {
        this.sum = sum;
        payActions.add(PayActions.MASTERCARD, ()-> System.out.println(Thread.currentThread().getName() + " : " + sum));
        payActions.add(PayActions.PAYPAL, ()-> System.out.println(Thread.currentThread().getName() + " : " + sum));
        payActions.add(PayActions.WEBMONEY, ()-> System.out.println(Thread.currentThread().getName() + " : " + sum));
        payActions.add(PayActions.VISA, ()-> System.out.println(Thread.currentThread().getName() + " : " + sum));
    }

    public void payOrder(PayActions payName) {
        payActions.get(payName).run();
    }
}


enum PayActions{
    MASTERCARD, VISA, WEBMONEY, PAYPAL
}

