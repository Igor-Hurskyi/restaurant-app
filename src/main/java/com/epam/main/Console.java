package com.epam.main;

import com.epam.client.Client;
import com.epam.general.Cities;
import com.epam.general.MyScanner;
import com.epam.restaurant.Order;
import com.epam.restaurant.Restaurant;

public class Console {

	public static void main(String[] args) {

		System.out.println("-help for help, actually");

		Cities city = determinateCity();

		Restaurant restaurant = new Restaurant(city);

		boolean isNextClient = true;

		while (isNextClient) {
			Client client = new Client();
			client.getCash();
//			Order order = client.makeOrder();
//			restaurant.processOrder(order);
//			client.eat();
//			client.pay();
//			client.leave();
//			order.printPrice();
//			isNextClient = restaurant.checkNewClient();
		}
	}

	private static Cities determinateCity() {  //remake like we do it on setCash
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