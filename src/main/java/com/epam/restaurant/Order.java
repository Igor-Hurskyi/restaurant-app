package com.epam.restaurant;

import com.epam.general.Drinks;
import com.epam.general.Food;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {

    final List<Food> foodList;
    final List<Drinks> drinksList;

    private final long ID;

    double price;

    public Order(List<Food> foodList, List<Drinks> drinkList) {
        this.foodList = new ArrayList<>(foodList);
        this.drinksList = new ArrayList<>(drinkList);
        price = 0;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ID = timestamp.getTime();

        System.out.print("Created new " + IDtoString() + " order: ");
        display();
    }

    public void iterateFoodList() {
        for (Food food : foodList) {
            System.out.print("[" + food + "] ");
        }
    }

    public void iterateDrinksList() {
        for (Drinks drink : drinksList) {
            System.out.print("[" + drink + "] ");
        }
    }

    public void printPrice() {
        System.out.println(price);
    }

    public String IDtoString() {
        return "@" + Long.toString(ID);
    }

    public void display() {
        iterateFoodList();
        iterateDrinksList();
    }
}
