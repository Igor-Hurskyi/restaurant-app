import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Restaurant {

    Map<String, Double> foodPrices;
    Map<String, Double> drinksPrices;

    Queue<Order> orders;

    Restaurant(Cities city) {
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

        foodPrices = new HashMap<>();
        drinksPrices = new HashMap<>();
    }

    private void formPricesForLviv() {
    }

    private void formPricesForKyiv() {
    }

    private void formPricesForDnipro() {
    }

    public void processOrder(Client client) {
    }

    public boolean checkNewClient() {
        return true;
    }

}
