package com.epam.restaurant;

import com.epam.general.Cities;
import com.epam.general.Drinks;
import com.epam.general.Food;
import com.epam.general.MyScanner;

import java.util.*;

public class Restaurant {

	private Map<String, Double> foodPrices;
	private Map<String, Double> drinksPrices;

	private Queue<Order> orders;

	public Restaurant(Cities city) {
		foodPrices = new HashMap<>();
		drinksPrices = new HashMap<>();

		switch (city) {
			case Lviv:
				formPricesForLviv();
				break;
			case Kyiv:
				formPricesForKyiv();
				break;
			case Dnipro:
				formPricesForDnipro();
				break;
		}

		orders = new PriorityQueue<>(); // why this queue?
	}

	private void formPricesForLviv() {
		foodPrices.put(Food.soup.toString(), 10.0);
		foodPrices.put(Food.rice.toString(), 15.0);
		foodPrices.put(Food.potato.toString(), 12.0);
		foodPrices.put(Food.pork.toString(), 20.0);
		foodPrices.put(Food.pasta.toString(), 16.0);
		foodPrices.put(Food.mutton.toString(), 22.0);
		foodPrices.put(Food.veal.toString(), 25.0);

		drinksPrices.put(Drinks.CocaCola.toString(), 12.0);
		drinksPrices.put(Drinks.Pepsi.toString(), 10.0);
		drinksPrices.put(Drinks.beer.toString(), 15.0);
		drinksPrices.put(Drinks.wine.toString(), 21.0);
		drinksPrices.put(Drinks.vodka.toString(), 20.0);
		drinksPrices.put(Drinks.whiskey.toString(), 25.0);
	}

	private void formPricesForKyiv() {
		foodPrices.put(Food.soup.toString(), 15.0);
		foodPrices.put(Food.rice.toString(), 15.0);
		foodPrices.put(Food.potato.toString(), 12.0);
		foodPrices.put(Food.pork.toString(), 24.0);
		foodPrices.put(Food.pasta.toString(), 16.0);
		foodPrices.put(Food.mutton.toString(), 22.0);
		foodPrices.put(Food.veal.toString(), 20.0);

		drinksPrices.put(Drinks.CocaCola.toString(), 15.0);
		drinksPrices.put(Drinks.Pepsi.toString(), 8.0);
		drinksPrices.put(Drinks.beer.toString(), 20.0);
		drinksPrices.put(Drinks.wine.toString(), 18.0);
		drinksPrices.put(Drinks.vodka.toString(), 24.0);
		drinksPrices.put(Drinks.whiskey.toString(), 22.0);
	}

	private void formPricesForDnipro() {
		foodPrices.put(Food.soup.toString(), 12.0);
		foodPrices.put(Food.rice.toString(), 14.0);
		foodPrices.put(Food.potato.toString(), 15.0);
		foodPrices.put(Food.pork.toString(), 10.0);
		foodPrices.put(Food.pasta.toString(), 16.0);
		foodPrices.put(Food.mutton.toString(), 35.0);
		foodPrices.put(Food.veal.toString(), 25.0);

		drinksPrices.put(Drinks.CocaCola.toString(), 20.0);
		drinksPrices.put(Drinks.Pepsi.toString(), 5.0);
		drinksPrices.put(Drinks.beer.toString(), 10.0);
		drinksPrices.put(Drinks.wine.toString(), 18.0);
		drinksPrices.put(Drinks.vodka.toString(), 15.0);
		drinksPrices.put(Drinks.whiskey.toString(), 12.0);
	}

	private void generatePrice(Order order) {
		for (Food food : order.foodList) {
			order.price += foodPrices.get(food.toString());
		}
		for (Drinks drinks : order.drinksList) {
			order.price += drinksPrices.get(drinks.toString());
		}
	}

	public void processOrder(Order order) {
		generatePrice(order);
		System.out.println("\nOrder " + order.IDtoString() + " delivered.");
	}

	public boolean checkNewClient() {
		System.out.print("Is there another client? (y/n): ");
		return MyScanner.getInstance().next().charAt(0) == 'y';
	}

}