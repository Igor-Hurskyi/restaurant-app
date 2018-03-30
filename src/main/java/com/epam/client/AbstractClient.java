package com.epam.client;

import com.epam.database.Drinks;
import com.epam.database.Food;
import com.epam.utils.MyScanner;
import com.epam.restaurant.Order;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractClient implements Human {

	double cash;

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

	private List<Food> selectFood() {

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

	protected void setCash() {

	}

	public void eat() {
		System.out.println("Client eat.");
	}

	public void pay(Order order) {
		System.out.print("Client paid ");
		order.printPrice();
	}

	public void leave() {
		System.out.println("Client leaved.");
	}
}
