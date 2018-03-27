import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Food> foodList;
    private List<Drinks> drinkList;

    Order(List<Food> foodList, List<Drinks> drinkList) {
        this.foodList = new ArrayList<>(foodList);
        this.drinkList = new ArrayList<>(drinkList);
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public List<Drinks> getDrinkList() {
        return drinkList;
    }
}
