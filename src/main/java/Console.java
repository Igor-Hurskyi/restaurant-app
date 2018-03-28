public class Console {

	public static void main(String[] args) {

		boolean isNextClient = true;
		Restaurant restaurant = new Restaurant(Cities.Lviv);
		Client client;

		while(isNextClient) {
			client = new Client();
			client.makeOrder();
			restaurant.processOrder(client);
			client.eat();
			client.pay();
			client.leave();
			isNextClient = restaurant.checkNewClient();
		}

	}
}