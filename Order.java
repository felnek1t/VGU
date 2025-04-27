import java.util.ArrayList;
import java.util.List;

public class Order {
    private int tableNumber;
    private List<Dish> dishes;

    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
        this.dishes = new ArrayList<>();
    }

    public boolean addDish(Dish dish) {
        // Проверка на дубликаты
        for (Dish existingDish : dishes) {
            if (existingDish.getName().equalsIgnoreCase(dish.getName())) {
                System.out.println("Dish \"" + dish.getName() + "\" already exists in the order.");
                return false;
            }
        }
        dishes.add(dish);
        System.out.println("Added dish: " + dish);
        return true;
    }

    public boolean removeDish(String dishName) {
        for (Dish dish : dishes) {
            if (dish.getName().equalsIgnoreCase(dishName)) {
                dishes.remove(dish);
                System.out.println("Removed dish: " + dish);
                return true;
            }
        }
        System.out.println("Dish \"" + dishName + "\" not found in the order.");
        return false;
    }

    public double calculateTotal() {
        double total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}