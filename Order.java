import java.util.ArrayList;
import java.util.List;

public class Order {
    private int tableNUMBER;
    private List<Dish> dishes;

    public Order(int tableNumber) {
        this.tableNUMBER = tableNumber;
        this.dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public double calculateTotal() {
        double total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    public int getTableNumber() {
        return tableNUMBER;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}