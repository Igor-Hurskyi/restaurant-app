package com.epam.main;

import com.epam.client.Client;
import com.epam.client.RichClient;
import com.epam.database.Cities;
import com.epam.utils.MyScanner;
import com.epam.restaurant.Order;
import com.epam.restaurant.Restaurant;

public class Console {

	public static void main(String[] args) {

		Cities city = determinateCity();

		Restaurant restaurant = new Restaurant(city);

		boolean isNextClient = true;

		while (isNextClient) {
			Client client = new RichClient();
			Order order = client.makeOrder();
			restaurant.processOrder(order);
			client.eat();
			client.pay(order);
			client.leave();
			isNextClient = restaurant.checkNewClient();
		}
	}

	private static Cities determinateCity() {
		Cities city;

		System.out.print("Determinate a city: ");

		try {
			city = Cities.valueOf(MyScanner.getInstance().nextLine());
		} catch (IllegalArgumentException e) {
			System.out.println("No such city detected.\n");
			city = determinateCity();
		}

		return city;
	}
}