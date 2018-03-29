package com.epam.client;

import com.epam.general.MyScanner;
import com.epam.restaurant.Order;

abstract class AbstractClient implements Human {

    double cash;

    protected double getCash() {
        return cash;
    }

    protected void setCash() {
        System.out.print("Set cash: ");
        while (MyScanner.getInstance().hasNext()) {
            if (MyScanner.getInstance().hasNextInt()) {
                cash = MyScanner.getInstance().nextInt();
                break;
            } else {
                System.out.print("Invalid input\n\nSet Cash: ");
                MyScanner.getInstance().next();
            }
        }
    }

    public void eat() {
        System.out.println("RichClient eat.");
    }

    public void pay(Order order) {
        System.out.print("RichClient paid ");
        order.printPrice();
    }

    public void leave() {
        System.out.println("RichClient leaved.");
    }
}
