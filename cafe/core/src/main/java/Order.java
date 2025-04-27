import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static final Logger logger = LoggerFactory.getLogger(Order.class);
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
                logger.warn("Dish \"{}\" already exists in the order.", dish.getName());
                return false;
            }
        }
        dishes.add(dish);
        logger.info("Added dish: {}", dish);
        return true;
    }

    public boolean removeDish(String dishName) {
        for (Dish dish : dishes) {
            if (dish.getName().equalsIgnoreCase(dishName)) {
                dishes.remove(dish);
                logger.info("Removed dish: {}", dish);
                return true;
            }
        }
        logger.warn("Dish \"{}\" not found in the order.", dishName);
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