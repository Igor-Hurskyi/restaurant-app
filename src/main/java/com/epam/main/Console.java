package com.epam.main;

import com.epam.client.Client;
import com.epam.general.Cities;
import com.epam.restaurant.Order;
import com.epam.restaurant.Restaurant;

public class Console {

	public static void main(String[] args) {

		Restaurant restaurant = new Restaurant(Cities.Lviv);

		boolean isNextClient = true;

		while(isNextClient) {
			Client client = new Client();
			Order order = client.makeOrder();
			restaurant.processOrder(order);
			client.eat();
			client.pay();
			client.leave();
			order.printPrice();
			isNextClient = restaurant.checkNewClient();
		}

	}
}