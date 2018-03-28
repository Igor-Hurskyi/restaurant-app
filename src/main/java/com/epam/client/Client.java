package com.epam.client;

import com.epam.general.Drinks;
import com.epam.general.Food;
import com.epam.restaurant.Order;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public Order makeOrder() {

		Order order;

		List<Food> foodList = new ArrayList<>();
		List<Drinks> drinksList = new ArrayList<>();

		foodList.add(Food.soup);
		foodList.add(Food.potato);

		drinksList.add(Drinks.CocaCola);
		drinksList.add(Drinks.whiskey);

		order = new Order(foodList, drinksList);

		return order;
	}

	public void eat() {
		System.out.println("Client eat.");
	}

	public void pay() {
		System.out.println("Client paid.");
	}

	public void leave() {
		System.out.println("Client leaved.");
	}
}
