package order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import dish.Dish;

public class Order {
    private static final Logger logger = LogManager.getLogger(Order.class);
    private int tableNumber;
    private List<Dish> dishes;
	private Menu menu;

    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
        this.dishes = new ArrayList<>();
    }
	public void setMenu(Menu menu) {
			this.menu = menu;
		}

    public boolean addDish(Dish dish) {
		if (menu != null && !menu.isDishAvailable(dish.getName())) {
            return false;
        }
		
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