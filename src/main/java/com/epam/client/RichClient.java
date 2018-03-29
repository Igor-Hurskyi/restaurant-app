package com.epam.client;

import com.epam.general.Drinks;
import com.epam.general.Food;
import com.epam.general.MyScanner;
import com.epam.restaurant.Order;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class RichClient extends AbstractClient implements Client {

    public RichClient() {
        setCash();
    }

    public void cashToString() {
        System.out.println(getCash());
    }

    public Order makeOrder() {

        Order order;

        List<Food> foodList = selectFood();

        List<Drinks> drinksList = selectDrinks();

        order = new Order(foodList, drinksList);

        return order;
    }

    private List<Drinks> selectDrinks() {

        List<Drinks> drinksList = new ArrayList<>();
        boolean wantMore = true;

        while (wantMore) {
            Drinks drink = addDrinks();
            drinksList.add(drink);
            System.out.print("One more? (y/n): ");
            wantMore = MyScanner.getInstance().next().charAt(0) == 'y';
        }

        return drinksList;
    }

    private Drinks addDrinks() {
        Drinks drink;

        System.out.print("Select drink: ");

        try {
            drink = Drinks.valueOf(MyScanner.getInstance().next());
        } catch (IllegalArgumentException e) {
            System.out.print("No such drink detected.\n\n");
            drink = addDrinks();
        }

        return drink;
    }

    public List<Food> selectFood() {

        List<Food> foodList = new ArrayList<>();
        boolean wantMore = true;

        while (wantMore) {
            Food food = addFood();
            foodList.add(food);
            System.out.print("One more? (y/n): ");
            wantMore = MyScanner.getInstance().next().charAt(0) == 'y';
        }

        return foodList;
    }

    private Food addFood() {
        Food food;

        System.out.print("Select food: ");

        try {
            food = Food.valueOf(MyScanner.getInstance().next());
        } catch (IllegalArgumentException e) {
            System.out.print("No such food detected.\n\n");
            food = addFood();
        }

        return food;
    }

    @Override
    public void setCash() {
        System.out.print("Set cash: ");
        while (MyScanner.getInstance().hasNext()) {
            if (MyScanner.getInstance().hasNextInt()) {
                cash = MyScanner.getInstance().nextInt();
                if (cash < 250) {
                    System.out.print("Too poor for Rich Client.\n\nSet Cash: ");
                    MyScanner.getInstance().next();
                }
                break;
            } else {
                System.out.print("Invalid input\n\nSet Cash: ");
                MyScanner.getInstance().next();
            }
        }
    }

    @Override
    public void walk() {

    }

    @Override
    public void speak() {

    }

    @Override
    public void move() {

    }

    @Override
    public void sleep() {

    }
}
